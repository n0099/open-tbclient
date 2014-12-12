package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z {
    public static int agG;
    public static long agH;
    public static long agI;
    public static long agJ;
    public static int agK;
    public static int agL;
    public static long agM;

    public static void yY() {
        com.baidu.adp.lib.stats.q ef = x.ef();
        ef.r("action", "imcost");
        ef.r("dect", String.valueOf(agH));
        ef.r("dlsize", String.valueOf(agI));
        ef.r("dbt", String.valueOf(agJ));
        ef.r("pnum", String.valueOf(agK));
        ef.r("reqcost", String.valueOf(agM));
        ef.r("cpu", String.valueOf(agL));
        ef.r("totalNum", String.valueOf(agG));
        com.baidu.adp.lib.stats.f.es().b("im", ef);
        zg();
    }

    public static void zg() {
        agG = 0;
        agH = 0L;
        agI = 0L;
        agJ = 0L;
        agK = 0;
        agL = 0;
    }
}
