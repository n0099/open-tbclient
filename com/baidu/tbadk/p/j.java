package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cLC = 100;
    public static int cLD = 10;

    public static void awJ() {
        if (m.awL().awM()) {
            if (b.cLH > cLD) {
                b.awF();
            }
            if (a.cLE > cLD) {
                a.awF();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.cLE++;
        if (z2) {
            a.cLF++;
        } else if (z3) {
            a.cLG++;
        }
        if (a.cLE > cLC) {
            a.awF();
        }
    }

    public void c(f fVar) {
        if (m.awL().awM()) {
            if (b.cLH < cLC) {
                b.cLI += fVar.oi;
                b.cLJ += fVar.cLa;
                b.cLK += fVar.cLb;
                b.cLL += fVar.cLc;
                b.cLN += fVar.costTime;
                b.cLM += fVar.cLd;
                b.cLH++;
                return;
            }
            b.awF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cLE;
        public static int cLF;
        public static int cLG;

        public static void awF() {
            com.baidu.adp.lib.stats.a fU = l.fU();
            fU.append("action", "imbusy");
            fU.append("totalNum", String.valueOf(cLE));
            fU.append("tfailNum", String.valueOf(cLF));
            fU.append("qfailNum", String.valueOf(cLG));
            BdStatisticsManager.getInstance().performance("im", fU);
            resetData();
        }

        public static void resetData() {
            cLE = 0;
            cLF = 0;
            cLG = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cLH;
        public static long cLI;
        public static long cLJ;
        public static long cLK;
        public static int cLL;
        public static int cLM;
        public static long cLN;

        public static void awF() {
            com.baidu.adp.lib.stats.a fU = l.fU();
            fU.append("action", "imcost");
            fU.append("dect", String.valueOf(cLI));
            fU.append("dlsize", String.valueOf(cLJ));
            fU.append("dbt", String.valueOf(cLK));
            fU.append("pnum", String.valueOf(cLL));
            fU.append("reqcost", String.valueOf(cLN));
            fU.append("cpu", String.valueOf(cLM));
            fU.append("totalNum", String.valueOf(cLH));
            BdStatisticsManager.getInstance().performance("im", fU);
            awK();
        }

        public static void awK() {
            cLH = 0;
            cLI = 0L;
            cLJ = 0L;
            cLK = 0L;
            cLL = 0;
            cLM = 0;
        }
    }
}
