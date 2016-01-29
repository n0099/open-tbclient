package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aAR = 100;
    public static int aAS = 10;

    public static void FW() {
        if (aa.FY().FZ()) {
            if (b.aAW > aAS) {
                b.FP();
            }
            if (a.aAT > aAS) {
                a.FP();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aAT++;
        if (z2) {
            a.aAU++;
        } else if (z3) {
            a.aAV++;
        }
        if (a.aAT > aAR) {
            a.FP();
        }
    }

    public void c(p pVar) {
        if (aa.FY().FZ()) {
            if (b.aAW < aAR) {
                b.aAX += pVar.uW;
                b.aAY += pVar.FH;
                b.aAZ += pVar.aAt;
                b.aBa += pVar.aAu;
                b.aBc += pVar.Hm;
                b.aBb += pVar.aAk;
                b.aAW++;
                return;
            }
            b.FP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aAT;
        public static int aAU;
        public static int aAV;

        public static void FP() {
            com.baidu.adp.lib.stats.d hm = w.hm();
            hm.r("action", "imbusy");
            hm.r("totalNum", String.valueOf(aAT));
            hm.r("tfailNum", String.valueOf(aAU));
            hm.r("qfailNum", String.valueOf(aAV));
            com.baidu.adp.lib.stats.a.ht().a("im", hm);
            resetData();
        }

        public static void resetData() {
            aAT = 0;
            aAU = 0;
            aAV = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aAW;
        public static long aAX;
        public static long aAY;
        public static long aAZ;
        public static int aBa;
        public static int aBb;
        public static long aBc;

        public static void FP() {
            com.baidu.adp.lib.stats.d hm = w.hm();
            hm.r("action", "imcost");
            hm.r("dect", String.valueOf(aAX));
            hm.r("dlsize", String.valueOf(aAY));
            hm.r("dbt", String.valueOf(aAZ));
            hm.r("pnum", String.valueOf(aBa));
            hm.r("reqcost", String.valueOf(aBc));
            hm.r("cpu", String.valueOf(aBb));
            hm.r("totalNum", String.valueOf(aAW));
            com.baidu.adp.lib.stats.a.ht().a("im", hm);
            FX();
        }

        public static void FX() {
            aAW = 0;
            aAX = 0L;
            aAY = 0L;
            aAZ = 0L;
            aBa = 0;
            aBb = 0;
        }
    }
}
