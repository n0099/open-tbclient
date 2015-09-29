package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int axE = 100;
    public static int axF = 10;

    public static void DZ() {
        if (y.Eb().Ec()) {
            if (b.axJ > axF) {
                b.DO();
            }
            if (a.axG > axF) {
                a.DO();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.axG++;
        if (z2) {
            a.axH++;
        } else if (z3) {
            a.axI++;
        }
        if (a.axG > axE) {
            a.DO();
        }
    }

    public void c(m mVar) {
        if (y.Eb().Ec()) {
            if (b.axJ < axE) {
                b.axK += mVar.uF;
                b.axL += mVar.axd;
                b.axM += mVar.axe;
                b.axN += mVar.axf;
                b.axP += mVar.Gq;
                b.axO += mVar.awU;
                b.axJ++;
                return;
            }
            b.DO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int axG;
        public static int axH;
        public static int axI;

        public static void DO() {
            com.baidu.adp.lib.stats.d hb = u.hb();
            hb.q("action", "imbusy");
            hb.q("totalNum", String.valueOf(axG));
            hb.q("tfailNum", String.valueOf(axH));
            hb.q("qfailNum", String.valueOf(axI));
            com.baidu.adp.lib.stats.a.hi().a("im", hb);
            resetData();
        }

        public static void resetData() {
            axG = 0;
            axH = 0;
            axI = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int axJ;
        public static long axK;
        public static long axL;
        public static long axM;
        public static int axN;
        public static int axO;
        public static long axP;

        public static void DO() {
            com.baidu.adp.lib.stats.d hb = u.hb();
            hb.q("action", "imcost");
            hb.q("dect", String.valueOf(axK));
            hb.q("dlsize", String.valueOf(axL));
            hb.q("dbt", String.valueOf(axM));
            hb.q("pnum", String.valueOf(axN));
            hb.q("reqcost", String.valueOf(axP));
            hb.q("cpu", String.valueOf(axO));
            hb.q("totalNum", String.valueOf(axJ));
            com.baidu.adp.lib.stats.a.hi().a("im", hb);
            Ea();
        }

        public static void Ea() {
            axJ = 0;
            axK = 0L;
            axL = 0L;
            axM = 0L;
            axN = 0;
            axO = 0;
        }
    }
}
