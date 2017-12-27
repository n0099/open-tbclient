package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int byy = 100;
    public static int byz = 10;

    public static void NY() {
        if (r.Oa().Ob()) {
            if (b.byD > byz) {
                b.NS();
            }
            if (a.byA > byz) {
                a.NS();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.byA++;
        if (z2) {
            a.byB++;
        } else if (z3) {
            a.byC++;
        }
        if (a.byA > byy) {
            a.NS();
        }
    }

    public void c(i iVar) {
        if (r.Oa().Ob()) {
            if (b.byD < byy) {
                b.byE += iVar.aiV;
                b.byF += iVar.asQ;
                b.byG += iVar.bxV;
                b.byH += iVar.bxW;
                b.byJ += iVar.auq;
                b.byI += iVar.bxM;
                b.byD++;
                return;
            }
            b.NS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int byA;
        public static int byB;
        public static int byC;

        public static void NS() {
            com.baidu.adp.lib.stats.a nm = q.nm();
            nm.append("action", "imbusy");
            nm.append("totalNum", String.valueOf(byA));
            nm.append("tfailNum", String.valueOf(byB));
            nm.append("qfailNum", String.valueOf(byC));
            BdStatisticsManager.getInstance().performance("im", nm);
            resetData();
        }

        public static void resetData() {
            byA = 0;
            byB = 0;
            byC = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int byD;
        public static long byE;
        public static long byF;
        public static long byG;
        public static int byH;
        public static int byI;
        public static long byJ;

        public static void NS() {
            com.baidu.adp.lib.stats.a nm = q.nm();
            nm.append("action", "imcost");
            nm.append("dect", String.valueOf(byE));
            nm.append("dlsize", String.valueOf(byF));
            nm.append("dbt", String.valueOf(byG));
            nm.append("pnum", String.valueOf(byH));
            nm.append("reqcost", String.valueOf(byJ));
            nm.append("cpu", String.valueOf(byI));
            nm.append("totalNum", String.valueOf(byD));
            BdStatisticsManager.getInstance().performance("im", nm);
            NZ();
        }

        public static void NZ() {
            byD = 0;
            byE = 0L;
            byF = 0L;
            byG = 0L;
            byH = 0;
            byI = 0;
        }
    }
}
