package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKH = 100;
    public static int aKI = 10;

    public static void Gz() {
        if (r.GB().GC()) {
            if (b.aKM > aKI) {
                b.Gt();
            }
            if (a.aKJ > aKI) {
                a.Gt();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKJ++;
        if (z2) {
            a.aKK++;
        } else if (z3) {
            a.aKL++;
        }
        if (a.aKJ > aKH) {
            a.Gt();
        }
    }

    public void c(i iVar) {
        if (r.GB().GC()) {
            if (b.aKM < aKH) {
                b.aKN += iVar.uH;
                b.aKO += iVar.EL;
                b.aKP += iVar.aKe;
                b.aKQ += iVar.aKf;
                b.aKS += iVar.Gn;
                b.aKR += iVar.aJV;
                b.aKM++;
                return;
            }
            b.Gt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKJ;
        public static int aKK;
        public static int aKL;

        public static void Gt() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aKJ));
            fK.p("tfailNum", String.valueOf(aKK));
            fK.p("qfailNum", String.valueOf(aKL));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aKJ = 0;
            aKK = 0;
            aKL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKM;
        public static long aKN;
        public static long aKO;
        public static long aKP;
        public static int aKQ;
        public static int aKR;
        public static long aKS;

        public static void Gt() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aKN));
            fK.p("dlsize", String.valueOf(aKO));
            fK.p("dbt", String.valueOf(aKP));
            fK.p("pnum", String.valueOf(aKQ));
            fK.p("reqcost", String.valueOf(aKS));
            fK.p("cpu", String.valueOf(aKR));
            fK.p("totalNum", String.valueOf(aKM));
            BdStatisticsManager.getInstance().performance("im", fK);
            GA();
        }

        public static void GA() {
            aKM = 0;
            aKN = 0L;
            aKO = 0L;
            aKP = 0L;
            aKQ = 0;
            aKR = 0;
        }
    }
}
