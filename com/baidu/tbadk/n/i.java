package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class i extends j {
    public static int fJG = 100;
    public static int fJH = 10;

    public static void bEe() {
        if (k.bEg().isSmallFlow()) {
            if (b.fJL > fJH) {
                b.bEc();
            }
            if (a.fJI > fJH) {
                a.bEc();
            }
        }
    }

    public static void h(boolean z, boolean z2, boolean z3) {
        a.fJI++;
        if (z2) {
            a.fJJ++;
        } else if (z3) {
            a.fJK++;
        }
        if (a.fJI > fJG) {
            a.bEc();
        }
    }

    public void c(f fVar) {
        if (k.bEg().isSmallFlow()) {
            if (b.fJL < fJG) {
                b.fJM += fVar.LK;
                b.fJN += fVar.fJe;
                b.fJO += fVar.fJf;
                b.fJP += fVar.fJg;
                b.fJR += fVar.costTime;
                b.fJQ += fVar.fJh;
                b.fJL++;
                return;
            }
            b.bEc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fJI;
        public static int fJJ;
        public static int fJK;

        public static void bEc() {
            com.baidu.adp.lib.stats.a pg = j.pg();
            pg.append("action", "imbusy");
            pg.append("totalNum", String.valueOf(fJI));
            pg.append("tfailNum", String.valueOf(fJJ));
            pg.append("qfailNum", String.valueOf(fJK));
            BdStatisticsManager.getInstance().performance("im", pg);
            resetData();
        }

        public static void resetData() {
            fJI = 0;
            fJJ = 0;
            fJK = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fJL;
        public static long fJM;
        public static long fJN;
        public static long fJO;
        public static int fJP;
        public static int fJQ;
        public static long fJR;

        public static void bEc() {
            com.baidu.adp.lib.stats.a pg = j.pg();
            pg.append("action", "imcost");
            pg.append("dect", String.valueOf(fJM));
            pg.append("dlsize", String.valueOf(fJN));
            pg.append("dbt", String.valueOf(fJO));
            pg.append("pnum", String.valueOf(fJP));
            pg.append("reqcost", String.valueOf(fJR));
            pg.append("cpu", String.valueOf(fJQ));
            pg.append("totalNum", String.valueOf(fJL));
            BdStatisticsManager.getInstance().performance("im", pg);
            bEf();
        }

        public static void bEf() {
            fJL = 0;
            fJM = 0L;
            fJN = 0L;
            fJO = 0L;
            fJP = 0;
            fJQ = 0;
        }
    }
}
