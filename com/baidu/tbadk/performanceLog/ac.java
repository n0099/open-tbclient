package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac {
    public static int aqM;
    public static int aqN;
    public static int aqO;

    public static void Do() {
        com.baidu.adp.lib.stats.q hm = ab.hm();
        hm.r("action", "imbusy");
        hm.r("totalNum", String.valueOf(aqM));
        hm.r("tfailNum", String.valueOf(aqN));
        hm.r("qfailNum", String.valueOf(aqO));
        com.baidu.adp.lib.stats.f.hz().b("im", hm);
        resetData();
    }

    public static void resetData() {
        aqM = 0;
        aqN = 0;
        aqO = 0;
    }
}
