package com.baidu.tbadk.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends TbConfig {
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    public static final Long WC = 3600000L;
    public static final Long WD = 36000000L;
    public static final Long WE = 36000000L;
    public static final Long WF = 86400000L;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static final String WG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String WH = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int WI = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static final Long WJ = 3600000L;

    public static final String uD() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String uE() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }
}
