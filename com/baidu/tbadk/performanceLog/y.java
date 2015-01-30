package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
    public static int ahb;
    public static int ahc;
    public static int ahd;

    public static void zp() {
        com.baidu.adp.lib.stats.q ed = x.ed();
        ed.r("action", "imbusy");
        ed.r("totalNum", String.valueOf(ahb));
        ed.r("tfailNum", String.valueOf(ahc));
        ed.r("qfailNum", String.valueOf(ahd));
        com.baidu.adp.lib.stats.f.eq().b("im", ed);
        resetData();
    }

    public static void resetData() {
        ahb = 0;
        ahc = 0;
        ahd = 0;
    }
}
