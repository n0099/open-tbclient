package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int axF = 100;
    public static int axG = 10;

    public static void DW() {
        if (y.DY().DZ()) {
            if (b.axK > axG) {
                b.DL();
            }
            if (a.axH > axG) {
                a.DL();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.axH++;
        if (z2) {
            a.axI++;
        } else if (z3) {
            a.axJ++;
        }
        if (a.axH > axF) {
            a.DL();
        }
    }

    public void c(m mVar) {
        if (y.DY().DZ()) {
            if (b.axK < axF) {
                b.axL += mVar.uF;
                b.axM += mVar.axe;
                b.axN += mVar.axf;
                b.axO += mVar.axg;
                b.axQ += mVar.Gr;
                b.axP += mVar.awV;
                b.axK++;
                return;
            }
            b.DL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int axH;
        public static int axI;
        public static int axJ;

        public static void DL() {
            com.baidu.adp.lib.stats.d hb = u.hb();
            hb.q("action", "imbusy");
            hb.q("totalNum", String.valueOf(axH));
            hb.q("tfailNum", String.valueOf(axI));
            hb.q("qfailNum", String.valueOf(axJ));
            com.baidu.adp.lib.stats.a.hi().a("im", hb);
            resetData();
        }

        public static void resetData() {
            axH = 0;
            axI = 0;
            axJ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int axK;
        public static long axL;
        public static long axM;
        public static long axN;
        public static int axO;
        public static int axP;
        public static long axQ;

        public static void DL() {
            com.baidu.adp.lib.stats.d hb = u.hb();
            hb.q("action", "imcost");
            hb.q("dect", String.valueOf(axL));
            hb.q("dlsize", String.valueOf(axM));
            hb.q("dbt", String.valueOf(axN));
            hb.q("pnum", String.valueOf(axO));
            hb.q("reqcost", String.valueOf(axQ));
            hb.q("cpu", String.valueOf(axP));
            hb.q("totalNum", String.valueOf(axK));
            com.baidu.adp.lib.stats.a.hi().a("im", hb);
            DX();
        }

        public static void DX() {
            axK = 0;
            axL = 0L;
            axM = 0L;
            axN = 0L;
            axO = 0;
            axP = 0;
        }
    }
}
