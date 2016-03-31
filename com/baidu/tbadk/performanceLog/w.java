package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aBM = 100;
    public static int aBN = 10;

    public static void GS() {
        if (aa.GU().GV()) {
            if (b.aBR > aBN) {
                b.GM();
            }
            if (a.aBO > aBN) {
                a.GM();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aBO++;
        if (z2) {
            a.aBP++;
        } else if (z3) {
            a.aBQ++;
        }
        if (a.aBO > aBM) {
            a.GM();
        }
    }

    public void c(p pVar) {
        if (aa.GU().GV()) {
            if (b.aBR < aBM) {
                b.aBS += pVar.vh;
                b.aBT += pVar.FN;
                b.aBU += pVar.aBi;
                b.aBV += pVar.aBj;
                b.aBX += pVar.Hs;
                b.aBW += pVar.aAZ;
                b.aBR++;
                return;
            }
            b.GM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aBO;
        public static int aBP;
        public static int aBQ;

        public static void GM() {
            com.baidu.adp.lib.stats.d hs = w.hs();
            hs.r("action", "imbusy");
            hs.r("totalNum", String.valueOf(aBO));
            hs.r("tfailNum", String.valueOf(aBP));
            hs.r("qfailNum", String.valueOf(aBQ));
            com.baidu.adp.lib.stats.a.hz().a("im", hs);
            resetData();
        }

        public static void resetData() {
            aBO = 0;
            aBP = 0;
            aBQ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aBR;
        public static long aBS;
        public static long aBT;
        public static long aBU;
        public static int aBV;
        public static int aBW;
        public static long aBX;

        public static void GM() {
            com.baidu.adp.lib.stats.d hs = w.hs();
            hs.r("action", "imcost");
            hs.r("dect", String.valueOf(aBS));
            hs.r("dlsize", String.valueOf(aBT));
            hs.r("dbt", String.valueOf(aBU));
            hs.r("pnum", String.valueOf(aBV));
            hs.r("reqcost", String.valueOf(aBX));
            hs.r("cpu", String.valueOf(aBW));
            hs.r("totalNum", String.valueOf(aBR));
            com.baidu.adp.lib.stats.a.hz().a("im", hs);
            GT();
        }

        public static void GT() {
            aBR = 0;
            aBS = 0L;
            aBT = 0L;
            aBU = 0L;
            aBV = 0;
            aBW = 0;
        }
    }
}
