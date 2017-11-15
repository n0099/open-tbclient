package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKc = 100;
    public static int aKd = 10;

    public static void Gr() {
        if (r.Gt().Gu()) {
            if (b.aKh > aKd) {
                b.Gl();
            }
            if (a.aKe > aKd) {
                a.Gl();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKe++;
        if (z2) {
            a.aKf++;
        } else if (z3) {
            a.aKg++;
        }
        if (a.aKe > aKc) {
            a.Gl();
        }
    }

    public void c(i iVar) {
        if (r.Gt().Gu()) {
            if (b.aKh < aKc) {
                b.aKi += iVar.uK;
                b.aKj += iVar.EM;
                b.aKk += iVar.aJz;
                b.aKl += iVar.aJA;
                b.aKn += iVar.Gn;
                b.aKm += iVar.aJq;
                b.aKh++;
                return;
            }
            b.Gl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKe;
        public static int aKf;
        public static int aKg;

        public static void Gl() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aKe));
            fK.p("tfailNum", String.valueOf(aKf));
            fK.p("qfailNum", String.valueOf(aKg));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aKe = 0;
            aKf = 0;
            aKg = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKh;
        public static long aKi;
        public static long aKj;
        public static long aKk;
        public static int aKl;
        public static int aKm;
        public static long aKn;

        public static void Gl() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aKi));
            fK.p("dlsize", String.valueOf(aKj));
            fK.p("dbt", String.valueOf(aKk));
            fK.p("pnum", String.valueOf(aKl));
            fK.p("reqcost", String.valueOf(aKn));
            fK.p("cpu", String.valueOf(aKm));
            fK.p("totalNum", String.valueOf(aKh));
            BdStatisticsManager.getInstance().performance("im", fK);
            Gs();
        }

        public static void Gs() {
            aKh = 0;
            aKi = 0L;
            aKj = 0L;
            aKk = 0L;
            aKl = 0;
            aKm = 0;
        }
    }
}
