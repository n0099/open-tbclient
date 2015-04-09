package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac {
    public static int apK;
    public static int apL;
    public static int apM;

    public static void CD() {
        com.baidu.adp.lib.stats.q hC = ab.hC();
        hC.r("action", "imbusy");
        hC.r("totalNum", String.valueOf(apK));
        hC.r("tfailNum", String.valueOf(apL));
        hC.r("qfailNum", String.valueOf(apM));
        com.baidu.adp.lib.stats.f.hP().b("im", hC);
        resetData();
    }

    public static void resetData() {
        apK = 0;
        apL = 0;
        apM = 0;
    }
}
