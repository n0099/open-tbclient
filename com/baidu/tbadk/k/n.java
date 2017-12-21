package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKK = 100;
    public static int aKL = 10;

    public static void Gz() {
        if (r.GB().GC()) {
            if (b.aKP > aKL) {
                b.Gt();
            }
            if (a.aKM > aKL) {
                a.Gt();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKM++;
        if (z2) {
            a.aKN++;
        } else if (z3) {
            a.aKO++;
        }
        if (a.aKM > aKK) {
            a.Gt();
        }
    }

    public void c(i iVar) {
        if (r.GB().GC()) {
            if (b.aKP < aKK) {
                b.aKQ += iVar.uI;
                b.aKR += iVar.EM;
                b.aKS += iVar.aKh;
                b.aKT += iVar.aKi;
                b.aKV += iVar.Go;
                b.aKU += iVar.aJY;
                b.aKP++;
                return;
            }
            b.Gt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKM;
        public static int aKN;
        public static int aKO;

        public static void Gt() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aKM));
            fK.p("tfailNum", String.valueOf(aKN));
            fK.p("qfailNum", String.valueOf(aKO));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aKM = 0;
            aKN = 0;
            aKO = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKP;
        public static long aKQ;
        public static long aKR;
        public static long aKS;
        public static int aKT;
        public static int aKU;
        public static long aKV;

        public static void Gt() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aKQ));
            fK.p("dlsize", String.valueOf(aKR));
            fK.p("dbt", String.valueOf(aKS));
            fK.p("pnum", String.valueOf(aKT));
            fK.p("reqcost", String.valueOf(aKV));
            fK.p("cpu", String.valueOf(aKU));
            fK.p("totalNum", String.valueOf(aKP));
            BdStatisticsManager.getInstance().performance("im", fK);
            GA();
        }

        public static void GA() {
            aKP = 0;
            aKQ = 0L;
            aKR = 0L;
            aKS = 0L;
            aKT = 0;
            aKU = 0;
        }
    }
}
