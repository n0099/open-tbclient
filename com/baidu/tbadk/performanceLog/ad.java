package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad {
    public static int apF;
    public static long apG;
    public static long apH;
    public static long apI;
    public static int apJ;
    public static int apK;
    public static long apL;

    public static void Cx() {
        com.baidu.adp.lib.stats.q hC = ab.hC();
        hC.r("action", "imcost");
        hC.r("dect", String.valueOf(apG));
        hC.r("dlsize", String.valueOf(apH));
        hC.r("dbt", String.valueOf(apI));
        hC.r("pnum", String.valueOf(apJ));
        hC.r("reqcost", String.valueOf(apL));
        hC.r("cpu", String.valueOf(apK));
        hC.r("totalNum", String.valueOf(apF));
        com.baidu.adp.lib.stats.f.hP().b("im", hC);
        CJ();
    }

    public static void CJ() {
        apF = 0;
        apG = 0L;
        apH = 0L;
        apI = 0L;
        apJ = 0;
        apK = 0;
    }
}
