package com.baidu.tbadk.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends TbConfig {
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    public static final Long Wz = 3600000L;
    public static final Long WA = 36000000L;
    public static final Long WB = 36000000L;
    public static final Long WC = 86400000L;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static final String WD = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String WE = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int WF = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static final Long WG = 3600000L;

    public static final String ux() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String uy() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }
}
