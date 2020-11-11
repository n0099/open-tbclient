package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int fvC = 100;
    public static int fvD = 10;

    public static void bCs() {
        if (m.bCu().bCv()) {
            if (b.fvH > fvD) {
                b.bCo();
            }
            if (a.fvE > fvD) {
                a.bCo();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.fvE++;
        if (z2) {
            a.fvF++;
        } else if (z3) {
            a.fvG++;
        }
        if (a.fvE > fvC) {
            a.bCo();
        }
    }

    public void c(f fVar) {
        if (m.bCu().bCv()) {
            if (b.fvH < fvC) {
                b.fvI += fVar.Ls;
                b.fvJ += fVar.fuY;
                b.fvK += fVar.fuZ;
                b.fvL += fVar.fva;
                b.fvN += fVar.costTime;
                b.fvM += fVar.fvb;
                b.fvH++;
                return;
            }
            b.bCo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fvE;
        public static int fvF;
        public static int fvG;

        public static void bCo() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imbusy");
            mT.append("totalNum", String.valueOf(fvE));
            mT.append("tfailNum", String.valueOf(fvF));
            mT.append("qfailNum", String.valueOf(fvG));
            BdStatisticsManager.getInstance().performance("im", mT);
            resetData();
        }

        public static void resetData() {
            fvE = 0;
            fvF = 0;
            fvG = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fvH;
        public static long fvI;
        public static long fvJ;
        public static long fvK;
        public static int fvL;
        public static int fvM;
        public static long fvN;

        public static void bCo() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imcost");
            mT.append("dect", String.valueOf(fvI));
            mT.append("dlsize", String.valueOf(fvJ));
            mT.append("dbt", String.valueOf(fvK));
            mT.append("pnum", String.valueOf(fvL));
            mT.append("reqcost", String.valueOf(fvN));
            mT.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(fvM));
            mT.append("totalNum", String.valueOf(fvH));
            BdStatisticsManager.getInstance().performance("im", mT);
            bCt();
        }

        public static void bCt() {
            fvH = 0;
            fvI = 0L;
            fvJ = 0L;
            fvK = 0L;
            fvL = 0;
            fvM = 0;
        }
    }
}
