package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aGA = 100;
    public static int aGB = 10;

    public static void Gg() {
        if (aa.Gi().Gj()) {
            if (b.aGF > aGB) {
                b.Ga();
            }
            if (a.aGC > aGB) {
                a.Ga();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aGC++;
        if (z2) {
            a.aGD++;
        } else if (z3) {
            a.aGE++;
        }
        if (a.aGC > aGA) {
            a.Ga();
        }
    }

    public void c(p pVar) {
        if (aa.Gi().Gj()) {
            if (b.aGF < aGA) {
                b.aGG += pVar.vD;
                b.aGH += pVar.FZ;
                b.aGI += pVar.aFW;
                b.aGJ += pVar.aFX;
                b.aGL += pVar.HD;
                b.aGK += pVar.aFN;
                b.aGF++;
                return;
            }
            b.Ga();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aGC;
        public static int aGD;
        public static int aGE;

        public static void Ga() {
            com.baidu.adp.lib.stats.c fH = w.fH();
            fH.p("action", "imbusy");
            fH.p("totalNum", String.valueOf(aGC));
            fH.p("tfailNum", String.valueOf(aGD));
            fH.p("qfailNum", String.valueOf(aGE));
            BdStatisticsManager.getInstance().performance("im", fH);
            resetData();
        }

        public static void resetData() {
            aGC = 0;
            aGD = 0;
            aGE = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aGF;
        public static long aGG;
        public static long aGH;
        public static long aGI;
        public static int aGJ;
        public static int aGK;
        public static long aGL;

        public static void Ga() {
            com.baidu.adp.lib.stats.c fH = w.fH();
            fH.p("action", "imcost");
            fH.p("dect", String.valueOf(aGG));
            fH.p("dlsize", String.valueOf(aGH));
            fH.p("dbt", String.valueOf(aGI));
            fH.p("pnum", String.valueOf(aGJ));
            fH.p("reqcost", String.valueOf(aGL));
            fH.p("cpu", String.valueOf(aGK));
            fH.p("totalNum", String.valueOf(aGF));
            BdStatisticsManager.getInstance().performance("im", fH);
            Gh();
        }

        public static void Gh() {
            aGF = 0;
            aGG = 0L;
            aGH = 0L;
            aGI = 0L;
            aGJ = 0;
            aGK = 0;
        }
    }
}
