package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cMt = 100;
    public static int cMu = 10;

    public static void awL() {
        if (m.awN().awO()) {
            if (b.cMy > cMu) {
                b.awH();
            }
            if (a.cMv > cMu) {
                a.awH();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.cMv++;
        if (z2) {
            a.cMw++;
        } else if (z3) {
            a.cMx++;
        }
        if (a.cMv > cMt) {
            a.awH();
        }
    }

    public void c(f fVar) {
        if (m.awN().awO()) {
            if (b.cMy < cMt) {
                b.cMz += fVar.oK;
                b.cMA += fVar.cLR;
                b.cMB += fVar.cLS;
                b.cMC += fVar.cLT;
                b.cME += fVar.costTime;
                b.cMD += fVar.cLU;
                b.cMy++;
                return;
            }
            b.awH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cMv;
        public static int cMw;
        public static int cMx;

        public static void awH() {
            com.baidu.adp.lib.stats.a fU = l.fU();
            fU.append("action", "imbusy");
            fU.append("totalNum", String.valueOf(cMv));
            fU.append("tfailNum", String.valueOf(cMw));
            fU.append("qfailNum", String.valueOf(cMx));
            BdStatisticsManager.getInstance().performance("im", fU);
            resetData();
        }

        public static void resetData() {
            cMv = 0;
            cMw = 0;
            cMx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long cMA;
        public static long cMB;
        public static int cMC;
        public static int cMD;
        public static long cME;
        public static int cMy;
        public static long cMz;

        public static void awH() {
            com.baidu.adp.lib.stats.a fU = l.fU();
            fU.append("action", "imcost");
            fU.append("dect", String.valueOf(cMz));
            fU.append("dlsize", String.valueOf(cMA));
            fU.append("dbt", String.valueOf(cMB));
            fU.append("pnum", String.valueOf(cMC));
            fU.append("reqcost", String.valueOf(cME));
            fU.append("cpu", String.valueOf(cMD));
            fU.append("totalNum", String.valueOf(cMy));
            BdStatisticsManager.getInstance().performance("im", fU);
            awM();
        }

        public static void awM() {
            cMy = 0;
            cMz = 0L;
            cMA = 0L;
            cMB = 0L;
            cMC = 0;
            cMD = 0;
        }
    }
}
