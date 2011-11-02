package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.webkit.URLUtil;
/* loaded from: classes.dex */
public class Config {
    public static final long APP_OVERDUR_DRAFT_BOX = 604800000;
    public static final int APP_USE_TIMES_UPDATA_SD_DATABASE = 50;
    public static final String ATME_ADDRESS = "c/u/feed/atme";
    public static final String AT_SUGGEST_ADDRESS = "c/u/follow/sug";
    public static final String BROADCAST_AT_ME_NUM = "at_me";
    public static final String BROADCAST_FANS_NUM = "fans";
    public static final String BROADCAST_NOTIFY = "com.baidu.tieba.broadcast.notify";
    public static final String BROADCAST_RELAY_ME_NUM = "relay";
    public static final String BROADCAST_SERVICE = "com.baidu.tieba.broadcast.service";
    public static final int DATABASE_VERSION = 1;
    public static final String DING_THREAD_ADDRESS = "c/c/thread/comment";
    public static final String ERROR_UPLOAD_SERVER = "c/s/logupload";
    public static final String FATAL_ERROR_FILE = "fatal_error.log";
    public static final long FATAL_ERROR_FILE_MAX_SIZE = 204800;
    public static final long FATAL_ERROR_FILE_UPLOAD_SIZE = 20480;
    public static final String FOLLOW_ADDRESS = "c/c/user/follow";
    public static final String FORUM_ADDRESS = "c/f/forum/favolike";
    public static final String FREIND_LIST_ADDRESS = "c/u/follow/list";
    public static final String FROM_FILE = "from.dat";
    public static final String FRS_ADDRESS = "c/f/frs/page";
    public static final String GET_FANS_ADDRESS = "c/u/fans/page";
    public static final String GET_FOLLOW_ADDRESS = "c/u/follow/page";
    public static final String GET_MSG_ADDRESS = "c/s/msg";
    public static final String GET_SYNC_ADDRESS = "c/s/sync";
    public static final String GET_VCODE_ADDRESS = "c/f/anti/vcode";
    public static final String IMAGE_ADDRESS = "http://c.tieba.baidu.com/c/p/img?";
    public static final String LIKE_ADDRESS = "c/c/forum/like";
    public static final String LOGIN_ADDRESS = "c/s/login";
    public static final int MAX_ACCOUNT_CHAR_NUM = 14;
    public static final int MAX_ACCOUNT_CHINESE_NUM = 7;
    public static final int MAX_ASYNC_IMAGE_LOADER_NUM = 20;
    public static final int MAX_CASH_FRIEND_PHOTO_NUM = 500;
    public static final int MAX_CASH_PB_PHOTO_NUM = 5000;
    public static final int MAX_PASSWORD_CHAR_NUM = 14;
    public static final int MAX_SDRAM_PHOTO_NUM = 100;
    public static final int MAX_SDRAM_PIC_NUM = 30;
    public static final int MAX_SEARCH_HISTORY_NUM = 10;
    public static final int MIN_PASSWORD_CHAR_NUM = 6;
    public static final int NET_MSG_GETLENTH = 900002;
    public static final int NET_MSG_TOTALLENTH = 900001;
    public static final int NOTIFY_DOWNLOADING_ID = 10;
    public static final String PB_ADDRESS = "c/f/pb/page";
    public static final int PB_IMAGE_MAX_HEIGHT = 80;
    public static final int PB_IMAGE_MAX_WIDTH = 140;
    public static final int PB_LIST_ITEM_NETWORK_NUM = 30;
    public static final String PHONE_DATEBASE_NAME = "baidu_tieba.db";
    public static final String POST_THREAD_ADDRESS = "c/c/thread/add";
    public static final String PROFILE_MODIFY = "c/c/profile/modify";
    public static final String REGISTER_ADDRESS = "c/s/reg";
    public static final String REPLYME_ADDRESS = "c/u/feed/replyme";
    public static final String REPLY_THREAD_ADDRESS = "c/c/post/add";
    public static final String SERVER_ADDRESS = "http://c.tieba.baidu.com/";
    public static final String SETTINGFILE = "settings";
    public static final String SUGGEST_ADDRESS = "c/f/forum/sug";
    public static final int SYNC_MAX_TIMES = 10;
    public static final int SYNC_TIME_INTERVAL = 60000;
    public static final long THREAD_IMAGE_SAVE_MAX_TIME = 86400000;
    public static final String TMPDIRNAME = "tieba";
    public static final String TMP_DATABASE_NAME = "tieba_database.db";
    public static final String TMP_PIC_DIR_NAME = "image";
    public static final String UNFAVOLIKE_ADDRESS = "c/c/forum/unfavolike";
    public static final String UNFOLLOW_ADDRESS = "c/c/user/unfollow";
    public static final String UNLIKE_ADDRESS = "c/c/forum/unlike";
    public static final String UPLOAD_IMAGE_ADDRESS = "c/c/img/upload";
    public static final String USER_INFO_ADDRESS = "c/u/user/profile";
    public static String VERSION = "";
    public static String FROM = null;
    public static boolean COULD_UPDATE = true;
    public static String PHOTO_BIG_ADDRESS = "http://tb.himg.baidu.com/sys/portrait/item/";
    public static String PHOTO_SMALL_ADDRESS = "http://tb.himg.baidu.com/sys/portraitn/item/";
    public static final int PHOTO_DELAY_TIME = 300;
    public static int PB_LIST_ITEM_MAX_NUM = PHOTO_DELAY_TIME;
    public static final int MAX_POST_IMAGE_SIZE = 640;
    public static int THREAD_IMAGE_MAX_WIDTH = MAX_POST_IMAGE_SIZE;
    public static long APP_DATE_UPDATA_SD_DATABASE = 2592000000L;
    public static int BitmapQuality = 80;
    public static Bitmap.Config BitmapConfig = Bitmap.Config.RGB_565;
    public static String POSITION_PAGER_NAME = "贴吧客户端反馈";
    public static String POSITION_PAGER_ID = "2631903";
    public static int MSG_DEFAULT_FREQUENCY = PHOTO_DELAY_TIME;
    public static boolean MSG_DEFAULT_FANS_SWITCH = true;
    public static boolean MSG_DEFAULT_REPLYME_SWITCH = true;
    public static boolean MSG_DEFAULT_ATME_SWITCH = true;

    public static void setSmallPhotoAdress(String url) {
        if (URLUtil.isHttpUrl(url) || URLUtil.isHttpsUrl(url)) {
            PHOTO_SMALL_ADDRESS = url;
        }
    }

    public static void setBigPhotoAdress(String url) {
        if (URLUtil.isHttpUrl(url) || URLUtil.isHttpsUrl(url)) {
            PHOTO_BIG_ADDRESS = url;
        }
    }

    public static void setPbListNum(int num) {
        if (num >= 60 && num <= 1000) {
            PB_LIST_ITEM_MAX_NUM = num;
        }
    }

    public static void setThreadImageWidth(int width) {
        if (width >= 300 && width <= 1200) {
            THREAD_IMAGE_MAX_WIDTH = width;
        }
    }

    public static void setFeedBack(String forum_name, String forum_id) {
        if (forum_name != null && forum_name.length() > 0 && forum_id != null && forum_id.length() > 0) {
            POSITION_PAGER_NAME = forum_name;
            POSITION_PAGER_ID = forum_id;
        }
    }
}
