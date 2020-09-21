package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eUZ = 100;
    public static int eVa = 10;

    public static void bvq() {
        if (m.bvs().bvt()) {
            if (b.eVe > eVa) {
                b.bvm();
            }
            if (a.eVb > eVa) {
                a.bvm();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.eVb++;
        if (z2) {
            a.eVc++;
        } else if (z3) {
            a.eVd++;
        }
        if (a.eVb > eUZ) {
            a.bvm();
        }
    }

    public void c(f fVar) {
        if (m.bvs().bvt()) {
            if (b.eVe < eUZ) {
                b.eVf += fVar.Lc;
                b.eVg += fVar.eUw;
                b.eVh += fVar.eUx;
                b.eVi += fVar.eUy;
                b.eVk += fVar.costTime;
                b.eVj += fVar.eUz;
                b.eVe++;
                return;
            }
            b.bvm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eVb;
        public static int eVc;
        public static int eVd;

        public static void bvm() {
            com.baidu.adp.lib.stats.a mS = l.mS();
            mS.append("action", "imbusy");
            mS.append("totalNum", String.valueOf(eVb));
            mS.append("tfailNum", String.valueOf(eVc));
            mS.append("qfailNum", String.valueOf(eVd));
            BdStatisticsManager.getInstance().performance("im", mS);
            resetData();
        }

        public static void resetData() {
            eVb = 0;
            eVc = 0;
            eVd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eVe;
        public static long eVf;
        public static long eVg;
        public static long eVh;
        public static int eVi;
        public static int eVj;
        public static long eVk;

        public static void bvm() {
            com.baidu.adp.lib.stats.a mS = l.mS();
            mS.append("action", "imcost");
            mS.append("dect", String.valueOf(eVf));
            mS.append("dlsize", String.valueOf(eVg));
            mS.append("dbt", String.valueOf(eVh));
            mS.append("pnum", String.valueOf(eVi));
            mS.append("reqcost", String.valueOf(eVk));
            mS.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eVj));
            mS.append("totalNum", String.valueOf(eVe));
            BdStatisticsManager.getInstance().performance("im", mS);
            bvr();
        }

        public static void bvr() {
            eVe = 0;
            eVf = 0L;
            eVg = 0L;
            eVh = 0L;
            eVi = 0;
            eVj = 0;
        }
    }
}
