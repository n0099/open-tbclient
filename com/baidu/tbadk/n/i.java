package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class i extends j {
    public static int fMc = 100;
    public static int fMd = 10;

    public static void bHD() {
        if (k.bHF().isSmallFlow()) {
            if (b.fMh > fMd) {
                b.bHB();
            }
            if (a.fMe > fMd) {
                a.bHB();
            }
        }
    }

    public static void h(boolean z, boolean z2, boolean z3) {
        a.fMe++;
        if (z2) {
            a.fMf++;
        } else if (z3) {
            a.fMg++;
        }
        if (a.fMe > fMc) {
            a.bHB();
        }
    }

    public void c(f fVar) {
        if (k.bHF().isSmallFlow()) {
            if (b.fMh < fMc) {
                b.fMi += fVar.LQ;
                b.fMj += fVar.fLA;
                b.fMk += fVar.fLB;
                b.fMl += fVar.fLC;
                b.fMn += fVar.costTime;
                b.fMm += fVar.fLD;
                b.fMh++;
                return;
            }
            b.bHB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fMe;
        public static int fMf;
        public static int fMg;

        public static void bHB() {
            com.baidu.adp.lib.stats.a pi = j.pi();
            pi.append("action", "imbusy");
            pi.append("totalNum", String.valueOf(fMe));
            pi.append("tfailNum", String.valueOf(fMf));
            pi.append("qfailNum", String.valueOf(fMg));
            BdStatisticsManager.getInstance().performance("im", pi);
            resetData();
        }

        public static void resetData() {
            fMe = 0;
            fMf = 0;
            fMg = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fMh;
        public static long fMi;
        public static long fMj;
        public static long fMk;
        public static int fMl;
        public static int fMm;
        public static long fMn;

        public static void bHB() {
            com.baidu.adp.lib.stats.a pi = j.pi();
            pi.append("action", "imcost");
            pi.append("dect", String.valueOf(fMi));
            pi.append("dlsize", String.valueOf(fMj));
            pi.append("dbt", String.valueOf(fMk));
            pi.append("pnum", String.valueOf(fMl));
            pi.append("reqcost", String.valueOf(fMn));
            pi.append("cpu", String.valueOf(fMm));
            pi.append("totalNum", String.valueOf(fMh));
            BdStatisticsManager.getInstance().performance("im", pi);
            bHE();
        }

        public static void bHE() {
            fMh = 0;
            fMi = 0L;
            fMj = 0L;
            fMk = 0L;
            fMl = 0;
            fMm = 0;
        }
    }
}
