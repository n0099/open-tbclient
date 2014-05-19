package com.baidu.tbadk.coreExtra.live;
/* loaded from: classes.dex */
public class LiveStatusChangeDefinition {
    public static final String ERROR_PROMPT_CONNECTION_CLOSED = "Connection closed";
    public static final String ERROR_PROMPT_CONNECT_FAILED = "Connect failed";
    public static final String ERROR_PROMPT_CONNECT_PREPARE = "Init failed";
    public static final String ERROR_PROMPT_CREATE_ENGINE_FAILED = "Multimedia module failed";
    public static final String ERROR_PROMPT_NOT_SUPPORT = "System not support";
    public static final String ERROR_PROMPT_PLAY_FILE_ERROR = "Play file error";
    public static final String ERROR_PROMPT_PLAY_INVALID_CODEC = "Play invalid codec";
    public static final String ERROR_PROMPT_PLAY_NET_ERROR = "Play network error";
    public static final String ERROR_PROMPT_SERVICE_CRASHED = "Service crashed or killed";
    public static final String ERROR_PROMPT_START_PUB = "Publish failed";
    public static final String ERROR_PROMPT_TOKEN_EXPIRED = "Token expired";
    public static final String ERROR_PROMPT_USER_NULL = "User Id is null";
    public static final String GROUP_FOR_RECORD_PLAY = "000000001";
    public static final int LIVE_IDLE = 0;
    public static final int LIVE_INVALID = -1;
    public static final int LIVE_PLAYING_LIVE = 2;
    public static final int LIVE_PLAYING_RECORD = 3;
    public static final int LIVE_PUBLISHING = 1;
    public static final int LIVE_RECORD_NOTREADY = 1;
    public static final int LIVE_RECORD_READY = 2;
    public static final int LIVE_RECORD_RECORDING = 3;
    public static final int RECORD_TIME_UPLIMIT = 14340;
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_INVALID = -1;
    public static final int STATUS_PLAY_END = 17;
    public static final int STATUS_PLAY_PAUSED = 20;
    public static final int STATUS_PLAY_PLAYING = 19;
    public static final int STATUS_PLAY_PREPARING = 18;
    public static final int STATUS_PUBLISH_CONNECTED = 2;
    public static final int STATUS_PUBLISH_PAUSED = 4;
    public static final int STATUS_PUBLISH_PREPARING = 1;
    public static final int STATUS_PUBLISH_PUBLISHING = 3;
}
