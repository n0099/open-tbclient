package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKD = 100;
    public static int aKE = 10;

    public static void Gy() {
        if (r.GA().GB()) {
            if (b.aKI > aKE) {
                b.Gs();
            }
            if (a.aKF > aKE) {
                a.Gs();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKF++;
        if (z2) {
            a.aKG++;
        } else if (z3) {
            a.aKH++;
        }
        if (a.aKF > aKD) {
            a.Gs();
        }
    }

    public void c(i iVar) {
        if (r.GA().GB()) {
            if (b.aKI < aKD) {
                b.aKJ += iVar.uK;
                b.aKK += iVar.EM;
                b.aKL += iVar.aKa;
                b.aKM += iVar.aKb;
                b.aKO += iVar.Gn;
                b.aKN += iVar.aJR;
                b.aKI++;
                return;
            }
            b.Gs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKF;
        public static int aKG;
        public static int aKH;

        public static void Gs() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aKF));
            fK.p("tfailNum", String.valueOf(aKG));
            fK.p("qfailNum", String.valueOf(aKH));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aKF = 0;
            aKG = 0;
            aKH = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKI;
        public static long aKJ;
        public static long aKK;
        public static long aKL;
        public static int aKM;
        public static int aKN;
        public static long aKO;

        public static void Gs() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aKJ));
            fK.p("dlsize", String.valueOf(aKK));
            fK.p("dbt", String.valueOf(aKL));
            fK.p("pnum", String.valueOf(aKM));
            fK.p("reqcost", String.valueOf(aKO));
            fK.p("cpu", String.valueOf(aKN));
            fK.p("totalNum", String.valueOf(aKI));
            BdStatisticsManager.getInstance().performance("im", fK);
            Gz();
        }

        public static void Gz() {
            aKI = 0;
            aKJ = 0L;
            aKK = 0L;
            aKL = 0L;
            aKM = 0;
            aKN = 0;
        }
    }
}
