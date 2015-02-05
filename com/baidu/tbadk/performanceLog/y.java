package com.baidu.tbadk.performanceLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
    public static int agY;
    public static int agZ;
    public static int aha;

    public static void zj() {
        com.baidu.adp.lib.stats.q ed = x.ed();
        ed.r("action", "imbusy");
        ed.r("totalNum", String.valueOf(agY));
        ed.r("tfailNum", String.valueOf(agZ));
        ed.r("qfailNum", String.valueOf(aha));
        com.baidu.adp.lib.stats.f.eq().b("im", ed);
        resetData();
    }

    public static void resetData() {
        agY = 0;
        agZ = 0;
        aha = 0;
    }
}
