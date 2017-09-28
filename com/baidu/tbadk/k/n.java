package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJx = 100;
    public static int aJy = 10;

    public static void Ga() {
        if (r.Gc().Gd()) {
            if (b.aJC > aJy) {
                b.FU();
            }
            if (a.aJz > aJy) {
                a.FU();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aJz++;
        if (z2) {
            a.aJA++;
        } else if (z3) {
            a.aJB++;
        }
        if (a.aJz > aJx) {
            a.FU();
        }
    }

    public void c(i iVar) {
        if (r.Gc().Gd()) {
            if (b.aJC < aJx) {
                b.aJD += iVar.uJ;
                b.aJE += iVar.Fa;
                b.aJF += iVar.aIU;
                b.aJG += iVar.aIV;
                b.aJI += iVar.GB;
                b.aJH += iVar.aIL;
                b.aJC++;
                return;
            }
            b.FU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aJA;
        public static int aJB;
        public static int aJz;

        public static void FU() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aJz));
            fK.p("tfailNum", String.valueOf(aJA));
            fK.p("qfailNum", String.valueOf(aJB));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aJz = 0;
            aJA = 0;
            aJB = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aJC;
        public static long aJD;
        public static long aJE;
        public static long aJF;
        public static int aJG;
        public static int aJH;
        public static long aJI;

        public static void FU() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aJD));
            fK.p("dlsize", String.valueOf(aJE));
            fK.p("dbt", String.valueOf(aJF));
            fK.p("pnum", String.valueOf(aJG));
            fK.p("reqcost", String.valueOf(aJI));
            fK.p("cpu", String.valueOf(aJH));
            fK.p("totalNum", String.valueOf(aJC));
            BdStatisticsManager.getInstance().performance("im", fK);
            Gb();
        }

        public static void Gb() {
            aJC = 0;
            aJD = 0L;
            aJE = 0L;
            aJF = 0L;
            aJG = 0;
            aJH = 0;
        }
    }
}
