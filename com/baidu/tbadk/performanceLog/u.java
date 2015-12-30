package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int aAc = 100;
    public static int aAd = 10;

    public static void EF() {
        if (y.EH().EI()) {
            if (b.aAh > aAd) {
                b.Eu();
            }
            if (a.aAe > aAd) {
                a.Eu();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.aAe++;
        if (z2) {
            a.aAf++;
        } else if (z3) {
            a.aAg++;
        }
        if (a.aAe > aAc) {
            a.Eu();
        }
    }

    public void c(m mVar) {
        if (y.EH().EI()) {
            if (b.aAh < aAc) {
                b.aAi += mVar.uN;
                b.aAj += mVar.Fu;
                b.aAk += mVar.azC;
                b.aAl += mVar.azD;
                b.aAn += mVar.Ha;
                b.aAm += mVar.azt;
                b.aAh++;
                return;
            }
            b.Eu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aAe;
        public static int aAf;
        public static int aAg;

        public static void Eu() {
            com.baidu.adp.lib.stats.d he = u.he();
            he.q("action", "imbusy");
            he.q("totalNum", String.valueOf(aAe));
            he.q("tfailNum", String.valueOf(aAf));
            he.q("qfailNum", String.valueOf(aAg));
            com.baidu.adp.lib.stats.a.hl().a("im", he);
            resetData();
        }

        public static void resetData() {
            aAe = 0;
            aAf = 0;
            aAg = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aAh;
        public static long aAi;
        public static long aAj;
        public static long aAk;
        public static int aAl;
        public static int aAm;
        public static long aAn;

        public static void Eu() {
            com.baidu.adp.lib.stats.d he = u.he();
            he.q("action", "imcost");
            he.q("dect", String.valueOf(aAi));
            he.q("dlsize", String.valueOf(aAj));
            he.q("dbt", String.valueOf(aAk));
            he.q("pnum", String.valueOf(aAl));
            he.q("reqcost", String.valueOf(aAn));
            he.q("cpu", String.valueOf(aAm));
            he.q("totalNum", String.valueOf(aAh));
            com.baidu.adp.lib.stats.a.hl().a("im", he);
            EG();
        }

        public static void EG() {
            aAh = 0;
            aAi = 0L;
            aAj = 0L;
            aAk = 0L;
            aAl = 0;
            aAm = 0;
        }
    }
}
