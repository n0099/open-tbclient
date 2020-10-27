package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int fpI = 100;
    public static int fpJ = 10;

    public static void bzT() {
        if (m.bzV().bzW()) {
            if (b.fpN > fpJ) {
                b.bzP();
            }
            if (a.fpK > fpJ) {
                a.bzP();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.fpK++;
        if (z2) {
            a.fpL++;
        } else if (z3) {
            a.fpM++;
        }
        if (a.fpK > fpI) {
            a.bzP();
        }
    }

    public void c(f fVar) {
        if (m.bzV().bzW()) {
            if (b.fpN < fpI) {
                b.fpO += fVar.Ls;
                b.fpP += fVar.fpd;
                b.fpQ += fVar.fpe;
                b.fpR += fVar.fpf;
                b.fpT += fVar.costTime;
                b.fpS += fVar.fpg;
                b.fpN++;
                return;
            }
            b.bzP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fpK;
        public static int fpL;
        public static int fpM;

        public static void bzP() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imbusy");
            mT.append("totalNum", String.valueOf(fpK));
            mT.append("tfailNum", String.valueOf(fpL));
            mT.append("qfailNum", String.valueOf(fpM));
            BdStatisticsManager.getInstance().performance("im", mT);
            resetData();
        }

        public static void resetData() {
            fpK = 0;
            fpL = 0;
            fpM = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fpN;
        public static long fpO;
        public static long fpP;
        public static long fpQ;
        public static int fpR;
        public static int fpS;
        public static long fpT;

        public static void bzP() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imcost");
            mT.append("dect", String.valueOf(fpO));
            mT.append("dlsize", String.valueOf(fpP));
            mT.append("dbt", String.valueOf(fpQ));
            mT.append("pnum", String.valueOf(fpR));
            mT.append("reqcost", String.valueOf(fpT));
            mT.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(fpS));
            mT.append("totalNum", String.valueOf(fpN));
            BdStatisticsManager.getInstance().performance("im", mT);
            bzU();
        }

        public static void bzU() {
            fpN = 0;
            fpO = 0L;
            fpP = 0L;
            fpQ = 0L;
            fpR = 0;
            fpS = 0;
        }
    }
}
