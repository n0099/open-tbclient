package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac {
    public static int apC;
    public static int apD;
    public static int apE;

    public static void Cx() {
        com.baidu.adp.lib.stats.q hC = ab.hC();
        hC.r("action", "imbusy");
        hC.r("totalNum", String.valueOf(apC));
        hC.r("tfailNum", String.valueOf(apD));
        hC.r("qfailNum", String.valueOf(apE));
        com.baidu.adp.lib.stats.f.hP().b("im", hC);
        resetData();
    }

    public static void resetData() {
        apC = 0;
        apD = 0;
        apE = 0;
    }
}
