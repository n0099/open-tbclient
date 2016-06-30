package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int ayF = 100;
    public static int ayG = 10;

    public static void EU() {
        if (aa.EW().EX()) {
            if (b.ayK > ayG) {
                b.EO();
            }
            if (a.ayH > ayG) {
                a.EO();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.ayH++;
        if (z2) {
            a.ayI++;
        } else if (z3) {
            a.ayJ++;
        }
        if (a.ayH > ayF) {
            a.EO();
        }
    }

    public void c(p pVar) {
        if (aa.EW().EX()) {
            if (b.ayK < ayF) {
                b.ayL += pVar.kW;
                b.ayM += pVar.wh;
                b.ayN += pVar.ayb;
                b.ayO += pVar.ayc;
                b.ayQ += pVar.xM;
                b.ayP += pVar.axS;
                b.ayK++;
                return;
            }
            b.EO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int ayH;
        public static int ayI;
        public static int ayJ;

        public static void EO() {
            com.baidu.adp.lib.stats.d dH = w.dH();
            dH.q("action", "imbusy");
            dH.q("totalNum", String.valueOf(ayH));
            dH.q("tfailNum", String.valueOf(ayI));
            dH.q("qfailNum", String.valueOf(ayJ));
            com.baidu.adp.lib.stats.a.dO().a("im", dH);
            resetData();
        }

        public static void resetData() {
            ayH = 0;
            ayI = 0;
            ayJ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int ayK;
        public static long ayL;
        public static long ayM;
        public static long ayN;
        public static int ayO;
        public static int ayP;
        public static long ayQ;

        public static void EO() {
            com.baidu.adp.lib.stats.d dH = w.dH();
            dH.q("action", "imcost");
            dH.q("dect", String.valueOf(ayL));
            dH.q("dlsize", String.valueOf(ayM));
            dH.q("dbt", String.valueOf(ayN));
            dH.q("pnum", String.valueOf(ayO));
            dH.q("reqcost", String.valueOf(ayQ));
            dH.q("cpu", String.valueOf(ayP));
            dH.q("totalNum", String.valueOf(ayK));
            com.baidu.adp.lib.stats.a.dO().a("im", dH);
            EV();
        }

        public static void EV() {
            ayK = 0;
            ayL = 0L;
            ayM = 0L;
            ayN = 0L;
            ayO = 0;
            ayP = 0;
        }
    }
}
