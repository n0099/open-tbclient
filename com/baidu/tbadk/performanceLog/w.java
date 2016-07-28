package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int azv = 100;
    public static int azw = 10;

    public static void ET() {
        if (aa.EV().EW()) {
            if (b.azA > azw) {
                b.EN();
            }
            if (a.azx > azw) {
                a.EN();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.azx++;
        if (z2) {
            a.azy++;
        } else if (z3) {
            a.azz++;
        }
        if (a.azx > azv) {
            a.EN();
        }
    }

    public void c(p pVar) {
        if (aa.EV().EW()) {
            if (b.azA < azv) {
                b.azB += pVar.lB;
                b.azC += pVar.wI;
                b.azD += pVar.ayR;
                b.azE += pVar.ayS;
                b.azG += pVar.yn;
                b.azF += pVar.ayI;
                b.azA++;
                return;
            }
            b.EN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int azx;
        public static int azy;
        public static int azz;

        public static void EN() {
            com.baidu.adp.lib.stats.d dG = w.dG();
            dG.q("action", "imbusy");
            dG.q("totalNum", String.valueOf(azx));
            dG.q("tfailNum", String.valueOf(azy));
            dG.q("qfailNum", String.valueOf(azz));
            com.baidu.adp.lib.stats.a.dN().a("im", dG);
            resetData();
        }

        public static void resetData() {
            azx = 0;
            azy = 0;
            azz = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int azA;
        public static long azB;
        public static long azC;
        public static long azD;
        public static int azE;
        public static int azF;
        public static long azG;

        public static void EN() {
            com.baidu.adp.lib.stats.d dG = w.dG();
            dG.q("action", "imcost");
            dG.q("dect", String.valueOf(azB));
            dG.q("dlsize", String.valueOf(azC));
            dG.q("dbt", String.valueOf(azD));
            dG.q("pnum", String.valueOf(azE));
            dG.q("reqcost", String.valueOf(azG));
            dG.q("cpu", String.valueOf(azF));
            dG.q("totalNum", String.valueOf(azA));
            com.baidu.adp.lib.stats.a.dN().a("im", dG);
            EU();
        }

        public static void EU() {
            azA = 0;
            azB = 0L;
            azC = 0L;
            azD = 0L;
            azE = 0;
            azF = 0;
        }
    }
}
