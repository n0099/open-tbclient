package com.baidu.tbadk.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class b extends TbConfig {
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    public static final Long ani = 3600000L;
    public static final Long anj = 36000000L;
    public static final Long ank = 36000000L;
    public static final Long anl = 86400000L;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static final String anm = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String ann = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int ano = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static final Long anp = 3600000L;

    public static final String zU() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }
}
