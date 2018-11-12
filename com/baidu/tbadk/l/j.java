package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bcH = 100;
    public static int bcI = 10;

    public static void Oe() {
        if (m.Og().Oh()) {
            if (b.bcM > bcI) {
                b.Oa();
            }
            if (a.bcJ > bcI) {
                a.Oa();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bcJ++;
        if (z2) {
            a.bcK++;
        } else if (z3) {
            a.bcL++;
        }
        if (a.bcJ > bcH) {
            a.Oa();
        }
    }

    public void c(f fVar) {
        if (m.Og().Oh()) {
            if (b.bcM < bcH) {
                b.bcN += fVar.Cw;
                b.bcO += fVar.bcf;
                b.bcP += fVar.bcg;
                b.bcQ += fVar.bch;
                b.bcS += fVar.NL;
                b.bcR += fVar.bci;
                b.bcM++;
                return;
            }
            b.Oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bcJ;
        public static int bcK;
        public static int bcL;

        public static void Oa() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imbusy");
            jB.append("totalNum", String.valueOf(bcJ));
            jB.append("tfailNum", String.valueOf(bcK));
            jB.append("qfailNum", String.valueOf(bcL));
            BdStatisticsManager.getInstance().performance("im", jB);
            resetData();
        }

        public static void resetData() {
            bcJ = 0;
            bcK = 0;
            bcL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bcM;
        public static long bcN;
        public static long bcO;
        public static long bcP;
        public static int bcQ;
        public static int bcR;
        public static long bcS;

        public static void Oa() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imcost");
            jB.append("dect", String.valueOf(bcN));
            jB.append("dlsize", String.valueOf(bcO));
            jB.append("dbt", String.valueOf(bcP));
            jB.append("pnum", String.valueOf(bcQ));
            jB.append("reqcost", String.valueOf(bcS));
            jB.append("cpu", String.valueOf(bcR));
            jB.append("totalNum", String.valueOf(bcM));
            BdStatisticsManager.getInstance().performance("im", jB);
            Of();
        }

        public static void Of() {
            bcM = 0;
            bcN = 0L;
            bcO = 0L;
            bcP = 0L;
            bcQ = 0;
            bcR = 0;
        }
    }
}
