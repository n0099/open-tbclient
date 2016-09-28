package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aCf = 100;
    public static int aCg = 10;

    public static void Gm() {
        if (aa.Go().Gp()) {
            if (b.aCk > aCg) {
                b.Gg();
            }
            if (a.aCh > aCg) {
                a.Gg();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aCh++;
        if (z2) {
            a.aCi++;
        } else if (z3) {
            a.aCj++;
        }
        if (a.aCh > aCf) {
            a.Gg();
        }
    }

    public void c(p pVar) {
        if (aa.Go().Gp()) {
            if (b.aCk < aCf) {
                b.aCl += pVar.nU;
                b.aCm += pVar.yU;
                b.aCn += pVar.aBB;
                b.aCo += pVar.aBC;
                b.aCq += pVar.AA;
                b.aCp += pVar.aBs;
                b.aCk++;
                return;
            }
            b.Gg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aCh;
        public static int aCi;
        public static int aCj;

        public static void Gg() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imbusy");
            eB.q("totalNum", String.valueOf(aCh));
            eB.q("tfailNum", String.valueOf(aCi));
            eB.q("qfailNum", String.valueOf(aCj));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            resetData();
        }

        public static void resetData() {
            aCh = 0;
            aCi = 0;
            aCj = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aCk;
        public static long aCl;
        public static long aCm;
        public static long aCn;
        public static int aCo;
        public static int aCp;
        public static long aCq;

        public static void Gg() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imcost");
            eB.q("dect", String.valueOf(aCl));
            eB.q("dlsize", String.valueOf(aCm));
            eB.q("dbt", String.valueOf(aCn));
            eB.q("pnum", String.valueOf(aCo));
            eB.q("reqcost", String.valueOf(aCq));
            eB.q("cpu", String.valueOf(aCp));
            eB.q("totalNum", String.valueOf(aCk));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            Gn();
        }

        public static void Gn() {
            aCk = 0;
            aCl = 0L;
            aCm = 0L;
            aCn = 0L;
            aCo = 0;
            aCp = 0;
        }
    }
}
