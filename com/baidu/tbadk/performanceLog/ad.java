package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad {
    public static int apN;
    public static long apO;
    public static long apP;
    public static long apQ;
    public static int apR;
    public static int apS;
    public static long apT;

    public static void CD() {
        com.baidu.adp.lib.stats.q hC = ab.hC();
        hC.r("action", "imcost");
        hC.r("dect", String.valueOf(apO));
        hC.r("dlsize", String.valueOf(apP));
        hC.r("dbt", String.valueOf(apQ));
        hC.r("pnum", String.valueOf(apR));
        hC.r("reqcost", String.valueOf(apT));
        hC.r("cpu", String.valueOf(apS));
        hC.r("totalNum", String.valueOf(apN));
        com.baidu.adp.lib.stats.f.hP().b("im", hC);
        CP();
    }

    public static void CP() {
        apN = 0;
        apO = 0L;
        apP = 0L;
        apQ = 0L;
        apR = 0;
        apS = 0;
    }
}
