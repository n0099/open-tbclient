package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class i extends j {
    public static int fLg = 100;
    public static int fLh = 10;

    public static void bEi() {
        if (k.bEk().isSmallFlow()) {
            if (b.fLl > fLh) {
                b.bEg();
            }
            if (a.fLi > fLh) {
                a.bEg();
            }
        }
    }

    public static void h(boolean z, boolean z2, boolean z3) {
        a.fLi++;
        if (z2) {
            a.fLj++;
        } else if (z3) {
            a.fLk++;
        }
        if (a.fLi > fLg) {
            a.bEg();
        }
    }

    public void c(f fVar) {
        if (k.bEk().isSmallFlow()) {
            if (b.fLl < fLg) {
                b.fLm += fVar.Ni;
                b.fLn += fVar.fKE;
                b.fLo += fVar.fKF;
                b.fLp += fVar.fKG;
                b.fLr += fVar.costTime;
                b.fLq += fVar.fKH;
                b.fLl++;
                return;
            }
            b.bEg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fLi;
        public static int fLj;
        public static int fLk;

        public static void bEg() {
            com.baidu.adp.lib.stats.a pg = j.pg();
            pg.append("action", "imbusy");
            pg.append("totalNum", String.valueOf(fLi));
            pg.append("tfailNum", String.valueOf(fLj));
            pg.append("qfailNum", String.valueOf(fLk));
            BdStatisticsManager.getInstance().performance("im", pg);
            resetData();
        }

        public static void resetData() {
            fLi = 0;
            fLj = 0;
            fLk = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fLl;
        public static long fLm;
        public static long fLn;
        public static long fLo;
        public static int fLp;
        public static int fLq;
        public static long fLr;

        public static void bEg() {
            com.baidu.adp.lib.stats.a pg = j.pg();
            pg.append("action", "imcost");
            pg.append("dect", String.valueOf(fLm));
            pg.append("dlsize", String.valueOf(fLn));
            pg.append("dbt", String.valueOf(fLo));
            pg.append("pnum", String.valueOf(fLp));
            pg.append("reqcost", String.valueOf(fLr));
            pg.append("cpu", String.valueOf(fLq));
            pg.append("totalNum", String.valueOf(fLl));
            BdStatisticsManager.getInstance().performance("im", pg);
            bEj();
        }

        public static void bEj() {
            fLl = 0;
            fLm = 0L;
            fLn = 0L;
            fLo = 0L;
            fLp = 0;
            fLq = 0;
        }
    }
}
