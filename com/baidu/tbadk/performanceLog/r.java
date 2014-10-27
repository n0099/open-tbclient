package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {
    public static int Zk;
    public static int Zl;
    public static int Zm;

    public static void uE() {
        com.baidu.adp.lib.stats.q logItem = q.getLogItem();
        logItem.n("action", "imbusy");
        logItem.n("totalNum", String.valueOf(Zk));
        logItem.n("tfailNum", String.valueOf(Zl));
        logItem.n("qfailNum", String.valueOf(Zm));
        com.baidu.adp.lib.stats.f.er().b("im", logItem);
        resetData();
    }

    public static void resetData() {
        Zk = 0;
        Zl = 0;
        Zm = 0;
    }
}
