package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int fhi = 100;
    public static int fhj = 10;

    public static void bya() {
        if (m.byc().byd()) {
            if (b.fhn > fhj) {
                b.bxW();
            }
            if (a.fhk > fhj) {
                a.bxW();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.fhk++;
        if (z2) {
            a.fhl++;
        } else if (z3) {
            a.fhm++;
        }
        if (a.fhk > fhi) {
            a.bxW();
        }
    }

    public void c(f fVar) {
        if (m.byc().byd()) {
            if (b.fhn < fhi) {
                b.fho += fVar.Ls;
                b.fhp += fVar.fgE;
                b.fhq += fVar.fgF;
                b.fhr += fVar.fgG;
                b.fht += fVar.costTime;
                b.fhs += fVar.fgH;
                b.fhn++;
                return;
            }
            b.bxW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fhk;
        public static int fhl;
        public static int fhm;

        public static void bxW() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imbusy");
            mT.append("totalNum", String.valueOf(fhk));
            mT.append("tfailNum", String.valueOf(fhl));
            mT.append("qfailNum", String.valueOf(fhm));
            BdStatisticsManager.getInstance().performance("im", mT);
            resetData();
        }

        public static void resetData() {
            fhk = 0;
            fhl = 0;
            fhm = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fhn;
        public static long fho;
        public static long fhp;
        public static long fhq;
        public static int fhr;
        public static int fhs;
        public static long fht;

        public static void bxW() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imcost");
            mT.append("dect", String.valueOf(fho));
            mT.append("dlsize", String.valueOf(fhp));
            mT.append("dbt", String.valueOf(fhq));
            mT.append("pnum", String.valueOf(fhr));
            mT.append("reqcost", String.valueOf(fht));
            mT.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(fhs));
            mT.append("totalNum", String.valueOf(fhn));
            BdStatisticsManager.getInstance().performance("im", mT);
            byb();
        }

        public static void byb() {
            fhn = 0;
            fho = 0L;
            fhp = 0L;
            fhq = 0L;
            fhr = 0;
            fhs = 0;
        }
    }
}
