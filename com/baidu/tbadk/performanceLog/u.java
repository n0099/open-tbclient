package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int axx = 100;
    public static int axy = 10;

    public static void Ec() {
        if (y.Ee().Ef()) {
            if (b.axC > axy) {
                b.DR();
            }
            if (a.axz > axy) {
                a.DR();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.axz++;
        if (z2) {
            a.axA++;
        } else if (z3) {
            a.axB++;
        }
        if (a.axz > axx) {
            a.DR();
        }
    }

    public void c(m mVar) {
        if (y.Ee().Ef()) {
            if (b.axC < axx) {
                b.axD += mVar.uH;
                b.axE += mVar.awW;
                b.axF += mVar.awX;
                b.axG += mVar.awY;
                b.axI += mVar.Gq;
                b.axH += mVar.awN;
                b.axC++;
                return;
            }
            b.DR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int axA;
        public static int axB;
        public static int axz;

        public static void DR() {
            com.baidu.adp.lib.stats.d hd = u.hd();
            hd.q("action", "imbusy");
            hd.q("totalNum", String.valueOf(axz));
            hd.q("tfailNum", String.valueOf(axA));
            hd.q("qfailNum", String.valueOf(axB));
            com.baidu.adp.lib.stats.a.hk().a("im", hd);
            resetData();
        }

        public static void resetData() {
            axz = 0;
            axA = 0;
            axB = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int axC;
        public static long axD;
        public static long axE;
        public static long axF;
        public static int axG;
        public static int axH;
        public static long axI;

        public static void DR() {
            com.baidu.adp.lib.stats.d hd = u.hd();
            hd.q("action", "imcost");
            hd.q("dect", String.valueOf(axD));
            hd.q("dlsize", String.valueOf(axE));
            hd.q("dbt", String.valueOf(axF));
            hd.q("pnum", String.valueOf(axG));
            hd.q("reqcost", String.valueOf(axI));
            hd.q("cpu", String.valueOf(axH));
            hd.q("totalNum", String.valueOf(axC));
            com.baidu.adp.lib.stats.a.hk().a("im", hd);
            Ed();
        }

        public static void Ed() {
            axC = 0;
            axD = 0L;
            axE = 0L;
            axF = 0L;
            axG = 0;
            axH = 0;
        }
    }
}
