package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aGV = 100;
    public static int aGW = 10;

    public static void FI() {
        if (aa.FK().FL()) {
            if (b.aHa > aGW) {
                b.FC();
            }
            if (a.aGX > aGW) {
                a.FC();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aGX++;
        if (z2) {
            a.aGY++;
        } else if (z3) {
            a.aGZ++;
        }
        if (a.aGX > aGV) {
            a.FC();
        }
    }

    public void c(p pVar) {
        if (aa.FK().FL()) {
            if (b.aHa < aGV) {
                b.aHb += pVar.vm;
                b.aHc += pVar.FD;
                b.aHd += pVar.aGs;
                b.aHe += pVar.aGt;
                b.aHg += pVar.Hg;
                b.aHf += pVar.aGj;
                b.aHa++;
                return;
            }
            b.FC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aGX;
        public static int aGY;
        public static int aGZ;

        public static void FC() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imbusy");
            fN.p("totalNum", String.valueOf(aGX));
            fN.p("tfailNum", String.valueOf(aGY));
            fN.p("qfailNum", String.valueOf(aGZ));
            BdStatisticsManager.getInstance().performance("im", fN);
            resetData();
        }

        public static void resetData() {
            aGX = 0;
            aGY = 0;
            aGZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aHa;
        public static long aHb;
        public static long aHc;
        public static long aHd;
        public static int aHe;
        public static int aHf;
        public static long aHg;

        public static void FC() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imcost");
            fN.p("dect", String.valueOf(aHb));
            fN.p("dlsize", String.valueOf(aHc));
            fN.p("dbt", String.valueOf(aHd));
            fN.p("pnum", String.valueOf(aHe));
            fN.p("reqcost", String.valueOf(aHg));
            fN.p("cpu", String.valueOf(aHf));
            fN.p("totalNum", String.valueOf(aHa));
            BdStatisticsManager.getInstance().performance("im", fN);
            FJ();
        }

        public static void FJ() {
            aHa = 0;
            aHb = 0L;
            aHc = 0L;
            aHd = 0L;
            aHe = 0;
            aHf = 0;
        }
    }
}
