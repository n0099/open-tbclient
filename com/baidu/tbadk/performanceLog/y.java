package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
    public static int agD;
    public static int agE;
    public static int agF;

    public static void yY() {
        com.baidu.adp.lib.stats.q ef = x.ef();
        ef.r("action", "imbusy");
        ef.r("totalNum", String.valueOf(agD));
        ef.r("tfailNum", String.valueOf(agE));
        ef.r("qfailNum", String.valueOf(agF));
        com.baidu.adp.lib.stats.f.es().b("im", ef);
        resetData();
    }

    public static void resetData() {
        agD = 0;
        agE = 0;
        agF = 0;
    }
}
