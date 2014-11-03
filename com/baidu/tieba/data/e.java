package com.baidu.tieba.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class e {
    public static String ajC = "http://tieba.baidu.com/";
    public static final Long ajD = 3600000L;
    public static final Long ajE = 36000000L;
    public static final Long ajF = 36000000L;
    public static final Long ajG = 86400000L;
    public static final String ajH = String.valueOf(ajC) + "mo/q/topic_page/136_1";
    public static final String ajI = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String ajJ = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int ajK = 80;
    private static int ajL = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
    private static int ajM = 1;
    public static final Long ajN = 3600000L;

    public static final String yv() {
        return "com.baidu.tieba.broadcast.imagepb.pageadded";
    }

    public static final String yw() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String yx() {
        return "com.baidu.tieba.broadcast.changeskin";
    }

    public static final String yy() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static final String yz() {
        return "com.baidu.tieba.broadcast.signalert";
    }

    public static int yA() {
        return ajL;
    }

    public static void dX(int i) {
        if (i >= 60 && i <= 1000) {
            ajL = i;
        }
    }

    public static void aa(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            TbConfig.setPositionPagerName(str);
            TbConfig.setPositionPagerId(str2);
        }
    }

    public static void dY(int i) {
        ajM = i;
    }
}
