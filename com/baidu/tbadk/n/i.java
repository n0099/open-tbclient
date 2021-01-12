package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class i extends j {
    public static int fHv = 100;
    public static int fHw = 10;

    public static void bDM() {
        if (k.bDO().isSmallFlow()) {
            if (b.fHA > fHw) {
                b.bDK();
            }
            if (a.fHx > fHw) {
                a.bDK();
            }
        }
    }

    public static void h(boolean z, boolean z2, boolean z3) {
        a.fHx++;
        if (z2) {
            a.fHy++;
        } else if (z3) {
            a.fHz++;
        }
        if (a.fHx > fHv) {
            a.bDK();
        }
    }

    public void c(f fVar) {
        if (k.bDO().isSmallFlow()) {
            if (b.fHA < fHv) {
                b.fHB += fVar.LN;
                b.fHC += fVar.fGT;
                b.fHD += fVar.fGU;
                b.fHE += fVar.fGV;
                b.fHG += fVar.costTime;
                b.fHF += fVar.fGW;
                b.fHA++;
                return;
            }
            b.bDK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fHx;
        public static int fHy;
        public static int fHz;

        public static void bDK() {
            com.baidu.adp.lib.stats.a pi = j.pi();
            pi.append("action", "imbusy");
            pi.append("totalNum", String.valueOf(fHx));
            pi.append("tfailNum", String.valueOf(fHy));
            pi.append("qfailNum", String.valueOf(fHz));
            BdStatisticsManager.getInstance().performance("im", pi);
            resetData();
        }

        public static void resetData() {
            fHx = 0;
            fHy = 0;
            fHz = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fHA;
        public static long fHB;
        public static long fHC;
        public static long fHD;
        public static int fHE;
        public static int fHF;
        public static long fHG;

        public static void bDK() {
            com.baidu.adp.lib.stats.a pi = j.pi();
            pi.append("action", "imcost");
            pi.append("dect", String.valueOf(fHB));
            pi.append("dlsize", String.valueOf(fHC));
            pi.append("dbt", String.valueOf(fHD));
            pi.append("pnum", String.valueOf(fHE));
            pi.append("reqcost", String.valueOf(fHG));
            pi.append("cpu", String.valueOf(fHF));
            pi.append("totalNum", String.valueOf(fHA));
            BdStatisticsManager.getInstance().performance("im", pi);
            bDN();
        }

        public static void bDN() {
            fHA = 0;
            fHB = 0L;
            fHC = 0L;
            fHD = 0L;
            fHE = 0;
            fHF = 0;
        }
    }
}
