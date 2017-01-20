package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aBi = 100;
    public static int aBj = 10;

    public static void FM() {
        if (aa.FO().FP()) {
            if (b.aBn > aBj) {
                b.FG();
            }
            if (a.aBk > aBj) {
                a.FG();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aBk++;
        if (z2) {
            a.aBl++;
        } else if (z3) {
            a.aBm++;
        }
        if (a.aBk > aBi) {
            a.FG();
        }
    }

    public void c(p pVar) {
        if (aa.FO().FP()) {
            if (b.aBn < aBi) {
                b.aBo += pVar.nO;
                b.aBp += pVar.yL;
                b.aBq += pVar.aAE;
                b.aBr += pVar.aAF;
                b.aBt += pVar.Aq;
                b.aBs += pVar.aAv;
                b.aBn++;
                return;
            }
            b.FG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aBk;
        public static int aBl;
        public static int aBm;

        public static void FG() {
            com.baidu.adp.lib.stats.d ez = w.ez();
            ez.q("action", "imbusy");
            ez.q("totalNum", String.valueOf(aBk));
            ez.q("tfailNum", String.valueOf(aBl));
            ez.q("qfailNum", String.valueOf(aBm));
            com.baidu.adp.lib.stats.a.eG().a("im", ez);
            resetData();
        }

        public static void resetData() {
            aBk = 0;
            aBl = 0;
            aBm = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aBn;
        public static long aBo;
        public static long aBp;
        public static long aBq;
        public static int aBr;
        public static int aBs;
        public static long aBt;

        public static void FG() {
            com.baidu.adp.lib.stats.d ez = w.ez();
            ez.q("action", "imcost");
            ez.q("dect", String.valueOf(aBo));
            ez.q("dlsize", String.valueOf(aBp));
            ez.q("dbt", String.valueOf(aBq));
            ez.q("pnum", String.valueOf(aBr));
            ez.q("reqcost", String.valueOf(aBt));
            ez.q("cpu", String.valueOf(aBs));
            ez.q("totalNum", String.valueOf(aBn));
            com.baidu.adp.lib.stats.a.eG().a("im", ez);
            FN();
        }

        public static void FN() {
            aBn = 0;
            aBo = 0L;
            aBp = 0L;
            aBq = 0L;
            aBr = 0;
            aBs = 0;
        }
    }
}
