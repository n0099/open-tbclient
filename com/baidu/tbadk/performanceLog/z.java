package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z {
    public static int ahb;
    public static long ahc;
    public static long ahd;
    public static long ahe;
    public static int ahf;
    public static int ahg;
    public static long ahh;

    public static void zj() {
        com.baidu.adp.lib.stats.q ed = x.ed();
        ed.r("action", "imcost");
        ed.r("dect", String.valueOf(ahc));
        ed.r("dlsize", String.valueOf(ahd));
        ed.r("dbt", String.valueOf(ahe));
        ed.r("pnum", String.valueOf(ahf));
        ed.r("reqcost", String.valueOf(ahh));
        ed.r("cpu", String.valueOf(ahg));
        ed.r("totalNum", String.valueOf(ahb));
        com.baidu.adp.lib.stats.f.eq().b("im", ed);
        zr();
    }

    public static void zr() {
        ahb = 0;
        ahc = 0L;
        ahd = 0L;
        ahe = 0L;
        ahf = 0;
        ahg = 0;
    }
}
