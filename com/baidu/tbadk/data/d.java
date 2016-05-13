package com.baidu.tbadk.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class d extends TbConfig {
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    public static final Long anI = 3600000L;
    public static final Long anJ = 36000000L;
    public static final Long anK = 36000000L;
    public static final Long anL = 86400000L;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static final String anM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String anN = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int anO = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static final Long anP = 3600000L;

    public static final String Ay() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }
}
