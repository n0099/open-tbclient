package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int ayz = 100;
    public static int ayA = 10;

    public static void EQ() {
        if (y.ES().ET()) {
            if (b.ayE > ayA) {
                b.EF();
            }
            if (a.ayB > ayA) {
                a.EF();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.ayB++;
        if (z2) {
            a.ayC++;
        } else if (z3) {
            a.ayD++;
        }
        if (a.ayB > ayz) {
            a.EF();
        }
    }

    public void c(m mVar) {
        if (y.ES().ET()) {
            if (b.ayE < ayz) {
                b.ayF += mVar.uL;
                b.ayG += mVar.axY;
                b.ayH += mVar.axZ;
                b.ayI += mVar.aya;
                b.ayK += mVar.GJ;
                b.ayJ += mVar.axP;
                b.ayE++;
                return;
            }
            b.EF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int ayB;
        public static int ayC;
        public static int ayD;

        public static void EF() {
            com.baidu.adp.lib.stats.d he = u.he();
            he.q("action", "imbusy");
            he.q("totalNum", String.valueOf(ayB));
            he.q("tfailNum", String.valueOf(ayC));
            he.q("qfailNum", String.valueOf(ayD));
            com.baidu.adp.lib.stats.a.hl().a("im", he);
            resetData();
        }

        public static void resetData() {
            ayB = 0;
            ayC = 0;
            ayD = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int ayE;
        public static long ayF;
        public static long ayG;
        public static long ayH;
        public static int ayI;
        public static int ayJ;
        public static long ayK;

        public static void EF() {
            com.baidu.adp.lib.stats.d he = u.he();
            he.q("action", "imcost");
            he.q("dect", String.valueOf(ayF));
            he.q("dlsize", String.valueOf(ayG));
            he.q("dbt", String.valueOf(ayH));
            he.q("pnum", String.valueOf(ayI));
            he.q("reqcost", String.valueOf(ayK));
            he.q("cpu", String.valueOf(ayJ));
            he.q("totalNum", String.valueOf(ayE));
            com.baidu.adp.lib.stats.a.hl().a("im", he);
            ER();
        }

        public static void ER() {
            ayE = 0;
            ayF = 0L;
            ayG = 0L;
            ayH = 0L;
            ayI = 0;
            ayJ = 0;
        }
    }
}
