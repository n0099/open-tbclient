package com.baidu.tieba.data;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class e {
    public static String ajt = "http://tieba.baidu.com/";
    public static final Long aju = 3600000L;
    public static final Long ajv = 36000000L;
    public static final Long ajw = 36000000L;
    public static final Long ajx = 86400000L;
    public static final String ajy = String.valueOf(ajt) + "mo/q/topic_page/136_1";
    public static final String ajz = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/recommend/";
    public static final String ajA = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/classic";
    public static int ajB = 80;
    private static int ajC = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
    private static int ajD = 1;
    public static final Long ajE = 3600000L;

    public static final String yt() {
        return "com.baidu.tieba.broadcast.imagepb.pageadded";
    }

    public static final String yu() {
        return "com.baidu.tieba.broadcast.service";
    }

    public static final String yv() {
        return "com.baidu.tieba.broadcast.changeskin";
    }

    public static final String yw() {
        return "com.baidu.tieba.broadcast.sync";
    }

    public static final String yx() {
        return "com.baidu.tieba.broadcast.signalert";
    }

    public static int yy() {
        return ajC;
    }

    public static void dX(int i) {
        if (i >= 60 && i <= 1000) {
            ajC = i;
        }
    }

    public static void aa(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            TbConfig.setPositionPagerName(str);
            TbConfig.setPositionPagerId(str2);
        }
    }

    public static void dY(int i) {
        ajD = i;
    }
}
