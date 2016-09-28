package com.baidu.tbadk.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class d extends TbConfig {
    public static String SERVER_ADDRESS_WEB_VIEW = "http://tieba.baidu.com/";
    public static final Long arW = 3600000L;
    public static final Long arX = 36000000L;
    public static final Long arY = 36000000L;
    public static final Long arZ = 86400000L;
    public static final String RECOMMEND_APP_ADDRESS = String.valueOf(SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/136_1";
    public static final String asa = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String asb = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int asc = 80;
    private static int PB_LIST_ITEM_MAX_NUM = 300;
    private static int IMG_CHUNK_UPLOAD_ENABLE = 1;
    public static final Long asd = 3600000L;

    public static int getPbListItemMaxNum() {
        return PB_LIST_ITEM_MAX_NUM;
    }
}
