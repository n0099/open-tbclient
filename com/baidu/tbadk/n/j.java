package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dzF = 100;
    public static int dzG = 10;

    public static void aOy() {
        if (m.aOA().aOB()) {
            if (b.dzK > dzG) {
                b.aOu();
            }
            if (a.dzH > dzG) {
                a.aOu();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dzH++;
        if (z2) {
            a.dzI++;
        } else if (z3) {
            a.dzJ++;
        }
        if (a.dzH > dzF) {
            a.aOu();
        }
    }

    public void c(f fVar) {
        if (m.aOA().aOB()) {
            if (b.dzK < dzF) {
                b.dzL += fVar.qE;
                b.dzM += fVar.dzd;
                b.dzN += fVar.dze;
                b.dzO += fVar.dzf;
                b.dzQ += fVar.costTime;
                b.dzP += fVar.dzg;
                b.dzK++;
                return;
            }
            b.aOu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dzH;
        public static int dzI;
        public static int dzJ;

        public static void aOu() {
            com.baidu.adp.lib.stats.a gt = l.gt();
            gt.append("action", "imbusy");
            gt.append("totalNum", String.valueOf(dzH));
            gt.append("tfailNum", String.valueOf(dzI));
            gt.append("qfailNum", String.valueOf(dzJ));
            BdStatisticsManager.getInstance().performance("im", gt);
            resetData();
        }

        public static void resetData() {
            dzH = 0;
            dzI = 0;
            dzJ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int dzK;
        public static long dzL;
        public static long dzM;
        public static long dzN;
        public static int dzO;
        public static int dzP;
        public static long dzQ;

        public static void aOu() {
            com.baidu.adp.lib.stats.a gt = l.gt();
            gt.append("action", "imcost");
            gt.append("dect", String.valueOf(dzL));
            gt.append("dlsize", String.valueOf(dzM));
            gt.append("dbt", String.valueOf(dzN));
            gt.append("pnum", String.valueOf(dzO));
            gt.append("reqcost", String.valueOf(dzQ));
            gt.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dzP));
            gt.append("totalNum", String.valueOf(dzK));
            BdStatisticsManager.getInstance().performance("im", gt);
            aOz();
        }

        public static void aOz() {
            dzK = 0;
            dzL = 0L;
            dzM = 0L;
            dzN = 0L;
            dzO = 0;
            dzP = 0;
        }
    }
}
