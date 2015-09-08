package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class u extends x {
    public static int azf = 100;
    public static int azg = 10;

    public static void Em() {
        if (y.Eo().Ep()) {
            if (b.azk > azg) {
                b.Eb();
            }
            if (a.azh > azg) {
                a.Eb();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        a.azh++;
        if (z2) {
            a.azi++;
        } else if (z3) {
            a.azj++;
        }
        if (a.azh > azf) {
            a.Eb();
        }
    }

    public void c(m mVar) {
        if (y.Eo().Ep()) {
            if (b.azk < azf) {
                b.azl += mVar.uF;
                b.azm += mVar.ayE;
                b.azn += mVar.ayF;
                b.azo += mVar.ayG;
                b.azq += mVar.Gq;
                b.azp += mVar.ayv;
                b.azk++;
                return;
            }
            b.Eb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int azh;
        public static int azi;
        public static int azj;

        public static void Eb() {
            com.baidu.adp.lib.stats.d ha = u.ha();
            ha.q("action", "imbusy");
            ha.q("totalNum", String.valueOf(azh));
            ha.q("tfailNum", String.valueOf(azi));
            ha.q("qfailNum", String.valueOf(azj));
            com.baidu.adp.lib.stats.a.hh().a("im", ha);
            resetData();
        }

        public static void resetData() {
            azh = 0;
            azi = 0;
            azj = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int azk;
        public static long azl;
        public static long azm;
        public static long azn;
        public static int azo;
        public static int azp;
        public static long azq;

        public static void Eb() {
            com.baidu.adp.lib.stats.d ha = u.ha();
            ha.q("action", "imcost");
            ha.q("dect", String.valueOf(azl));
            ha.q("dlsize", String.valueOf(azm));
            ha.q("dbt", String.valueOf(azn));
            ha.q("pnum", String.valueOf(azo));
            ha.q("reqcost", String.valueOf(azq));
            ha.q("cpu", String.valueOf(azp));
            ha.q("totalNum", String.valueOf(azk));
            com.baidu.adp.lib.stats.a.hh().a("im", ha);
            En();
        }

        public static void En() {
            azk = 0;
            azl = 0L;
            azm = 0L;
            azn = 0L;
            azo = 0;
            azp = 0;
        }
    }
}
