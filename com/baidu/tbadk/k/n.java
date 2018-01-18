package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int byH = 100;
    public static int byI = 10;

    public static void NM() {
        if (r.NO().NP()) {
            if (b.byM > byI) {
                b.NG();
            }
            if (a.byJ > byI) {
                a.NG();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.byJ++;
        if (z2) {
            a.byK++;
        } else if (z3) {
            a.byL++;
        }
        if (a.byJ > byH) {
            a.NG();
        }
    }

    public void c(i iVar) {
        if (r.NO().NP()) {
            if (b.byM < byH) {
                b.byN += iVar.aiV;
                b.byO += iVar.asP;
                b.byP += iVar.bye;
                b.byQ += iVar.byf;
                b.byS += iVar.aup;
                b.byR += iVar.bxV;
                b.byM++;
                return;
            }
            b.NG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int byJ;
        public static int byK;
        public static int byL;

        public static void NG() {
            com.baidu.adp.lib.stats.a nm = q.nm();
            nm.append("action", "imbusy");
            nm.append("totalNum", String.valueOf(byJ));
            nm.append("tfailNum", String.valueOf(byK));
            nm.append("qfailNum", String.valueOf(byL));
            BdStatisticsManager.getInstance().performance("im", nm);
            resetData();
        }

        public static void resetData() {
            byJ = 0;
            byK = 0;
            byL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int byM;
        public static long byN;
        public static long byO;
        public static long byP;
        public static int byQ;
        public static int byR;
        public static long byS;

        public static void NG() {
            com.baidu.adp.lib.stats.a nm = q.nm();
            nm.append("action", "imcost");
            nm.append("dect", String.valueOf(byN));
            nm.append("dlsize", String.valueOf(byO));
            nm.append("dbt", String.valueOf(byP));
            nm.append("pnum", String.valueOf(byQ));
            nm.append("reqcost", String.valueOf(byS));
            nm.append("cpu", String.valueOf(byR));
            nm.append("totalNum", String.valueOf(byM));
            BdStatisticsManager.getInstance().performance("im", nm);
            NN();
        }

        public static void NN() {
            byM = 0;
            byN = 0L;
            byO = 0L;
            byP = 0L;
            byQ = 0;
            byR = 0;
        }
    }
}
