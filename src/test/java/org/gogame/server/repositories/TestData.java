package org.gogame.server.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gogame.server.domain.entities.*;
import org.gogame.server.domain.entities.dto.UserLoginDto;
import org.gogame.server.domain.entities.dto.UserRegisterDto;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TestData {
    public static class UserEntityUtils {

        public static UserEntity createA() {
            return UserEntity.builder()
                    .nickname("romka")
                    .passwordHash("qwertyuiop")
                    .email("romka@romka.romka")
                    .joinDate(Timestamp.valueOf(LocalDateTime.of(2024, 1, 12, 18, 33, 11)))
                    .build();
        }

        public static UserEntity createB() {
            return UserEntity.builder()
                    .nickname("romka2")
                    .passwordHash("qwertyuiop2")
                    .email("romka2@romka.romka")
                    .joinDate(Timestamp.valueOf(LocalDateTime.of(2024, 1, 12, 18, 33, 12)))
                    .build();
        }

        public static UserEntity createC() {
            return UserEntity.builder()
                    .nickname("romka3")
                    .passwordHash("qwertyuiop3")
                    .email("romka3@romka.romka")
                    .joinDate(Timestamp.valueOf(LocalDateTime.of(2024, 1, 12, 18, 33, 12)))
                    .build();
        }
    }

    public static class RegisterDtoUtils {

        public static UserRegisterDto createA() {
            return UserRegisterDto.builder()
                    .nickname("romka")
                    .password("qwertyuiop")
                    .email("romka@romka.romka")
                    .build();
        }

        public static UserRegisterDto createB() {
            return UserRegisterDto.builder()
                    .nickname("romka2")
                    .password("qwertyuiop2")
                    .email("romka2@romka.romka")
                    .build();
        }

        public static UserRegisterDto createC() {
            return UserRegisterDto.builder()
                    .nickname("romka3")
                    .password("qwertyuiop3")
                    .email("romka3@romka.romka")
                    .build();
        }
    }

    public static class LoginDtoUtils {

        public static UserLoginDto createA() {
            return UserLoginDto.builder()
                    .nickname("romka")
                    .password("qwertyuiop")
                    .build();
        }

        public static UserLoginDto createB() {
            return UserLoginDto.builder()
                    .nickname("romka2")
                    .password("qwertyuiop2")
                    .build();
        }

        public static UserLoginDto createC() {
            return UserLoginDto.builder()
                    .nickname("romka3")
                    .password("qwertyuiop3")
                    .build();
        }

        public static UserLoginDto createUnknownUser() {
            return UserLoginDto.builder()
                    .nickname("c#")
                    .password("microsoft")
                    .build();
        }
    }

    public static String getJwtToken(MvcResult mvcResult) {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode;
        try {
            String responseContent = mvcResult.getResponse().getContentAsString();
            jsonNode = objectMapper.readTree(responseContent);
        } catch (Exception e) {
            System.err.println("Unable do decode JSON");
            return "";
        }
        return "Bearer " + jsonNode.get("token").asText();

    }
}