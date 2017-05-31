package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aGI = 100;
    public static int aGJ = 10;

    public static void FC() {
        if (aa.FE().FF()) {
            if (b.aGN > aGJ) {
                b.Fw();
            }
            if (a.aGK > aGJ) {
                a.Fw();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aGK++;
        if (z2) {
            a.aGL++;
        } else if (z3) {
            a.aGM++;
        }
        if (a.aGK > aGI) {
            a.Fw();
        }
    }

    public void c(p pVar) {
        if (aa.FE().FF()) {
            if (b.aGN < aGI) {
                b.aGO += pVar.vm;
                b.aGP += pVar.FD;
                b.aGQ += pVar.aGf;
                b.aGR += pVar.aGg;
                b.aGT += pVar.Hg;
                b.aGS += pVar.aFW;
                b.aGN++;
                return;
            }
            b.Fw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aGK;
        public static int aGL;
        public static int aGM;

        public static void Fw() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imbusy");
            fN.p("totalNum", String.valueOf(aGK));
            fN.p("tfailNum", String.valueOf(aGL));
            fN.p("qfailNum", String.valueOf(aGM));
            BdStatisticsManager.getInstance().performance("im", fN);
            resetData();
        }

        public static void resetData() {
            aGK = 0;
            aGL = 0;
            aGM = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aGN;
        public static long aGO;
        public static long aGP;
        public static long aGQ;
        public static int aGR;
        public static int aGS;
        public static long aGT;

        public static void Fw() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imcost");
            fN.p("dect", String.valueOf(aGO));
            fN.p("dlsize", String.valueOf(aGP));
            fN.p("dbt", String.valueOf(aGQ));
            fN.p("pnum", String.valueOf(aGR));
            fN.p("reqcost", String.valueOf(aGT));
            fN.p("cpu", String.valueOf(aGS));
            fN.p("totalNum", String.valueOf(aGN));
            BdStatisticsManager.getInstance().performance("im", fN);
            FD();
        }

        public static void FD() {
            aGN = 0;
            aGO = 0L;
            aGP = 0L;
            aGQ = 0L;
            aGR = 0;
            aGS = 0;
        }
    }
}
