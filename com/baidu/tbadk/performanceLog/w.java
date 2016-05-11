package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int axP = 100;
    public static int axQ = 10;

    public static void EK() {
        if (aa.EM().EN()) {
            if (b.axU > axQ) {
                b.EE();
            }
            if (a.axR > axQ) {
                a.EE();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.axR++;
        if (z2) {
            a.axS++;
        } else if (z3) {
            a.axT++;
        }
        if (a.axR > axP) {
            a.EE();
        }
    }

    public void c(p pVar) {
        if (aa.EM().EN()) {
            if (b.axU < axP) {
                b.axV += pVar.kY;
                b.axW += pVar.wf;
                b.axX += pVar.axl;
                b.axY += pVar.axm;
                b.aya += pVar.xK;
                b.axZ += pVar.axc;
                b.axU++;
                return;
            }
            b.EE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int axR;
        public static int axS;
        public static int axT;

        public static void EE() {
            com.baidu.adp.lib.stats.d dG = w.dG();
            dG.q("action", "imbusy");
            dG.q("totalNum", String.valueOf(axR));
            dG.q("tfailNum", String.valueOf(axS));
            dG.q("qfailNum", String.valueOf(axT));
            com.baidu.adp.lib.stats.a.dN().a("im", dG);
            resetData();
        }

        public static void resetData() {
            axR = 0;
            axS = 0;
            axT = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int axU;
        public static long axV;
        public static long axW;
        public static long axX;
        public static int axY;
        public static int axZ;
        public static long aya;

        public static void EE() {
            com.baidu.adp.lib.stats.d dG = w.dG();
            dG.q("action", "imcost");
            dG.q("dect", String.valueOf(axV));
            dG.q("dlsize", String.valueOf(axW));
            dG.q("dbt", String.valueOf(axX));
            dG.q("pnum", String.valueOf(axY));
            dG.q("reqcost", String.valueOf(aya));
            dG.q("cpu", String.valueOf(axZ));
            dG.q("totalNum", String.valueOf(axU));
            com.baidu.adp.lib.stats.a.dN().a("im", dG);
            EL();
        }

        public static void EL() {
            axU = 0;
            axV = 0L;
            axW = 0L;
            axX = 0L;
            axY = 0;
            axZ = 0;
        }
    }
}
