package com.baidu.tbadk.plugins;

import android.content.Context;
@com.baidu.tbplugin.a.c(a = "mp_wrapper")
@com.baidu.tbplugin.a.b(a = {"libbdpush_V1_0.so", "libBdMoplusMD5_V1.so"})
@com.baidu.tbplugin.a.a(a = "mp_wrapper.jar", b = "dex.wrapper.MPDelegateImpl")
/* loaded from: classes.dex */
public interface MPDelegate {
    public static final String ACTION_MESSAGE = "com.baidu.android.pushservice.action.MESSAGE";
    public static final String ACTION_METHOD = "com.baidu.android.pushservice.action.METHOD";
    public static final String ACTION_RECEIVE = "com.baidu.android.pushservice.action.RECEIVE";
    public static final String ACTION_RECEIVER_NOTIFICATION_CLICK = "com.baidu.android.pushservice.action.notification.CLICK";
    public static final String ACTION_SDK_MESSAGE = "com.baidu.android.pushservice.action.SDK_MESSAGE";
    public static final String ACTION_SDK_RECEIVE = "com.baidu.android.pushservice.action.sdk.RECEIVE";
    public static final String ACTION_WEB_RECEIVE = "com.baidu.android.pushservice.action.web.RECEIVE";
    public static final int BIND_STATUS_OFFLINE = 1;
    public static final int BIND_STATUS_ONLINE = 0;
    public static final int ERROR_AUTHENTICATION_FAILED = 30603;
    public static final int ERROR_BIND_NOT_EXIST = 30608;
    public static final int ERROR_BIND_OVERLOAD = 30609;
    public static final int ERROR_CHANNEL_TOKEN_TIMEOUT = 30607;
    public static final int ERROR_DATA_NOT_FOUND = 30605;
    public static final int ERROR_METHOD_ERROR = 30601;
    public static final int ERROR_NETWORK_ERROR = 10001;
    public static final int ERROR_PARAMS_ERROR = 30602;
    public static final int ERROR_QUOTA_USE_UP = 30604;
    public static final int ERROR_SERVER_INTERNAL_ERROR = 30600;
    public static final int ERROR_SERVICE_NOT_AVAILABLE = 10002;
    public static final int ERROR_SERVICE_NOT_AVAILABLE_TEMP = 10003;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_TIME_EXPIRES = 30606;
    public static final int ERROR_UNKNOWN = 20001;
    public static final String EXTRA_ACCESS_TOKEN = "access_token";
    public static final String EXTRA_API_KEY = "secret_key";
    public static final String EXTRA_APP = "app";
    public static final String EXTRA_APP_ID = "app_id";
    public static final String EXTRA_BIND_NAME = "bind_name";
    public static final String EXTRA_BIND_STATUS = "bind_status";
    public static final String EXTRA_CB_URL = "cb_url";
    public static final String EXTRA_CONTENT = "content";
    public static final String EXTRA_ERROR_CODE = "error_msg";
    public static final String EXTRA_EXTRA = "extra_extra_custom_content";
    public static final String EXTRA_FETCH_NUM = "fetch_num";
    public static final String EXTRA_FETCH_TYPE = "fetch_type";
    public static final String EXTRA_GID = "gid";
    public static final String EXTRA_GROUP_FETCH_NUM = "group_fetch_num";
    public static final String EXTRA_GROUP_FETCH_TYPE = "group_fetch_type";
    public static final String EXTRA_HASHCODE = "hash_code";
    public static final String EXTRA_METHOD = "method";
    public static final String EXTRA_MSG = "push_ msg";
    public static final String EXTRA_MSGID = "msgid";
    public static final String EXTRA_MSG_IDS = "msg_ids";
    public static final String EXTRA_MSG_KEY = "push_ msg_key";
    public static final String EXTRA_NOTIFICATION_CONTENT = "notification_content";
    public static final String EXTRA_NOTIFICATION_TITLE = "notification_title";
    public static final String EXTRA_OPENTYPE = "open_type";
    public static final String EXTRA_PUSH_MESSAGE = "message";
    public static final String EXTRA_PUSH_MESSAGE_STRING = "message_string";
    public static final String EXTRA_PUSH_SDK_VERSION = "push_sdk_version";
    public static final String EXTRA_TAGS = "tags";
    public static final String EXTRA_TAGS_LIST = "tags_list";
    public static final String EXTRA_TIMESTAMP = "time_stamp";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String EXTRA_WEB_BIND_API_KEY = "com.baidu.pushservice.webapp.apikey";
    public static final int LOGIN_TYPE_ACCESS_TOKEN = 1;
    public static final int LOGIN_TYPE_API_KEY = 0;
    public static final int LOGIN_TYPE_BDUSS = 2;
    public static final int LOGIN_TYPE_UNKNOWN = 9;
    public static final String METHOD_APPSTART = "method_appstart";
    public static final String METHOD_APPSTOP = "method_appstop";
    public static final String METHOD_BIND = "method_bind";
    public static final String METHOD_COUNT = "method_count";
    public static final String METHOD_COUNTGMSG = "method_countgmsg";
    public static final String METHOD_DELETE = "method_delete";
    public static final String METHOD_DEL_TAGS = "method_del_tags";
    public static final String METHOD_FETCH = "method_fetch";
    public static final String METHOD_FETCHGMSG = "method_fetchgmsg";
    public static final String METHOD_GBIND = "method_gbind";
    public static final String METHOD_GINFO = "method_ginfo";
    public static final String METHOD_GLIST = "method_glist";
    public static final String METHOD_GUNBIND = "method_gunbind";
    public static final String METHOD_LISTTAGS = "method_listtags";
    public static final String METHOD_ONLINE = "method_online";
    public static final String METHOD_SEND = "method_send";
    public static final String METHOD_SEND_MSG_TO_SERVER = "method_send_msg_to_server";
    public static final String METHOD_SEND_MSG_TO_USER = "method_send_msg_to_user";
    public static final String METHOD_SET_TAGS = "method_set_tags";
    public static final String METHOD_UNBIND = "method_unbind";
    public static final int OPEN_BY_NOTIFICATION = 1;
    public static final int OPEN_BY_USER = 0;
    public static final String PACKAGE_NAME = "pkg_name";

    void initFrontiaApplication(Context context);

    void restartMoPlusService(Context context);

    void startMoPlusService(Context context);

    void startPushService(Context context, int i, String str);

    void startPushService(Context context, String str, String str2);

    void stopPushService(Context context);
}
