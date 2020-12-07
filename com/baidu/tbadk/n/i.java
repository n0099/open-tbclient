package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class i extends k {
    public static int fCx = 100;
    public static int fCy = 10;

    public static void bFj() {
        if (l.bFl().isSmallFlow()) {
            if (b.fCC > fCy) {
                b.bFh();
            }
            if (a.fCz > fCy) {
                a.bFh();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.fCz++;
        if (z2) {
            a.fCA++;
        } else if (z3) {
            a.fCB++;
        }
        if (a.fCz > fCx) {
            a.bFh();
        }
    }

    public void c(f fVar) {
        if (l.bFl().isSmallFlow()) {
            if (b.fCC < fCx) {
                b.fCD += fVar.Mq;
                b.fCE += fVar.fBU;
                b.fCF += fVar.fBV;
                b.fCG += fVar.fBW;
                b.fCI += fVar.costTime;
                b.fCH += fVar.fBX;
                b.fCC++;
                return;
            }
            b.bFh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fCA;
        public static int fCB;
        public static int fCz;

        public static void bFh() {
            com.baidu.adp.lib.stats.a mT = k.mT();
            mT.append("action", "imbusy");
            mT.append("totalNum", String.valueOf(fCz));
            mT.append("tfailNum", String.valueOf(fCA));
            mT.append("qfailNum", String.valueOf(fCB));
            BdStatisticsManager.getInstance().performance("im", mT);
            resetData();
        }

        public static void resetData() {
            fCz = 0;
            fCA = 0;
            fCB = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fCC;
        public static long fCD;
        public static long fCE;
        public static long fCF;
        public static int fCG;
        public static int fCH;
        public static long fCI;

        public static void bFh() {
            com.baidu.adp.lib.stats.a mT = k.mT();
            mT.append("action", "imcost");
            mT.append("dect", String.valueOf(fCD));
            mT.append("dlsize", String.valueOf(fCE));
            mT.append("dbt", String.valueOf(fCF));
            mT.append("pnum", String.valueOf(fCG));
            mT.append("reqcost", String.valueOf(fCI));
            mT.append("cpu", String.valueOf(fCH));
            mT.append("totalNum", String.valueOf(fCC));
            BdStatisticsManager.getInstance().performance("im", mT);
            bFk();
        }

        public static void bFk() {
            fCC = 0;
            fCD = 0L;
            fCE = 0L;
            fCF = 0L;
            fCG = 0;
            fCH = 0;
        }
    }
}
