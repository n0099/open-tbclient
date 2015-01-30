package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z {
    public static int ahe;
    public static long ahf;
    public static long ahg;
    public static long ahh;
    public static int ahi;
    public static int ahj;
    public static long ahk;

    public static void zp() {
        com.baidu.adp.lib.stats.q ed = x.ed();
        ed.r("action", "imcost");
        ed.r("dect", String.valueOf(ahf));
        ed.r("dlsize", String.valueOf(ahg));
        ed.r("dbt", String.valueOf(ahh));
        ed.r("pnum", String.valueOf(ahi));
        ed.r("reqcost", String.valueOf(ahk));
        ed.r("cpu", String.valueOf(ahj));
        ed.r("totalNum", String.valueOf(ahe));
        com.baidu.adp.lib.stats.f.eq().b("im", ed);
        zx();
    }

    public static void zx() {
        ahe = 0;
        ahf = 0L;
        ahg = 0L;
        ahh = 0L;
        ahi = 0;
        ahj = 0;
    }
}
