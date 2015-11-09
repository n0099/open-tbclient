package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int awu = 100;
    public static int awv = 10;

    public static void DP() {
        if (y.DR().DS()) {
            if (b.awz > awv) {
                b.DE();
            }
            if (a.aww > awv) {
                a.DE();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.aww++;
        if (z2) {
            a.awx++;
        } else if (z3) {
            a.awy++;
        }
        if (a.aww > awu) {
            a.DE();
        }
    }

    public void c(m mVar) {
        if (y.DR().DS()) {
            if (b.awz < awu) {
                b.awA += mVar.uF;
                b.awB += mVar.avT;
                b.awC += mVar.avU;
                b.awD += mVar.avV;
                b.awF += mVar.Gs;
                b.awE += mVar.avK;
                b.awz++;
                return;
            }
            b.DE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aww;
        public static int awx;
        public static int awy;

        public static void DE() {
            com.baidu.adp.lib.stats.d hc = u.hc();
            hc.q("action", "imbusy");
            hc.q("totalNum", String.valueOf(aww));
            hc.q("tfailNum", String.valueOf(awx));
            hc.q("qfailNum", String.valueOf(awy));
            com.baidu.adp.lib.stats.a.hj().a("im", hc);
            resetData();
        }

        public static void resetData() {
            aww = 0;
            awx = 0;
            awy = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long awA;
        public static long awB;
        public static long awC;
        public static int awD;
        public static int awE;
        public static long awF;
        public static int awz;

        public static void DE() {
            com.baidu.adp.lib.stats.d hc = u.hc();
            hc.q("action", "imcost");
            hc.q("dect", String.valueOf(awA));
            hc.q("dlsize", String.valueOf(awB));
            hc.q("dbt", String.valueOf(awC));
            hc.q("pnum", String.valueOf(awD));
            hc.q("reqcost", String.valueOf(awF));
            hc.q("cpu", String.valueOf(awE));
            hc.q("totalNum", String.valueOf(awz));
            com.baidu.adp.lib.stats.a.hj().a("im", hc);
            DQ();
        }

        public static void DQ() {
            awz = 0;
            awA = 0L;
            awB = 0L;
            awC = 0L;
            awD = 0;
            awE = 0;
        }
    }
}
