package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {
    public static int Zo;
    public static int Zp;
    public static int Zq;

    public static void uG() {
        com.baidu.adp.lib.stats.q logItem = q.getLogItem();
        logItem.n("action", "imbusy");
        logItem.n("totalNum", String.valueOf(Zo));
        logItem.n("tfailNum", String.valueOf(Zp));
        logItem.n("qfailNum", String.valueOf(Zq));
        com.baidu.adp.lib.stats.f.er().b("im", logItem);
        resetData();
    }

    public static void resetData() {
        Zo = 0;
        Zp = 0;
        Zq = 0;
    }
}
