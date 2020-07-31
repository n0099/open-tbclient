package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eHz = 100;
    public static int eHA = 10;

    public static void bly() {
        if (m.blA().blB()) {
            if (b.eHE > eHA) {
                b.blu();
            }
            if (a.eHB > eHA) {
                a.blu();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.eHB++;
        if (z2) {
            a.eHC++;
        } else if (z3) {
            a.eHD++;
        }
        if (a.eHB > eHz) {
            a.blu();
        }
    }

    public void c(f fVar) {
        if (m.blA().blB()) {
            if (b.eHE < eHz) {
                b.eHF += fVar.Kp;
                b.eHG += fVar.eGV;
                b.eHH += fVar.eGW;
                b.eHI += fVar.eGX;
                b.eHK += fVar.costTime;
                b.eHJ += fVar.eGY;
                b.eHE++;
                return;
            }
            b.blu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eHB;
        public static int eHC;
        public static int eHD;

        public static void blu() {
            com.baidu.adp.lib.stats.a lo = l.lo();
            lo.append("action", "imbusy");
            lo.append("totalNum", String.valueOf(eHB));
            lo.append("tfailNum", String.valueOf(eHC));
            lo.append("qfailNum", String.valueOf(eHD));
            BdStatisticsManager.getInstance().performance("im", lo);
            resetData();
        }

        public static void resetData() {
            eHB = 0;
            eHC = 0;
            eHD = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eHE;
        public static long eHF;
        public static long eHG;
        public static long eHH;
        public static int eHI;
        public static int eHJ;
        public static long eHK;

        public static void blu() {
            com.baidu.adp.lib.stats.a lo = l.lo();
            lo.append("action", "imcost");
            lo.append("dect", String.valueOf(eHF));
            lo.append("dlsize", String.valueOf(eHG));
            lo.append("dbt", String.valueOf(eHH));
            lo.append("pnum", String.valueOf(eHI));
            lo.append("reqcost", String.valueOf(eHK));
            lo.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eHJ));
            lo.append("totalNum", String.valueOf(eHE));
            BdStatisticsManager.getInstance().performance("im", lo);
            blz();
        }

        public static void blz() {
            eHE = 0;
            eHF = 0L;
            eHG = 0L;
            eHH = 0L;
            eHI = 0;
            eHJ = 0;
        }
    }
}
