package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJZ = 100;
    public static int aKa = 10;

    public static void Gv() {
        if (r.Gx().Gy()) {
            if (b.aKe > aKa) {
                b.Gp();
            }
            if (a.aKb > aKa) {
                a.Gp();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKb++;
        if (z2) {
            a.aKc++;
        } else if (z3) {
            a.aKd++;
        }
        if (a.aKb > aJZ) {
            a.Gp();
        }
    }

    public void c(i iVar) {
        if (r.Gx().Gy()) {
            if (b.aKe < aJZ) {
                b.aKf += iVar.uH;
                b.aKg += iVar.EY;
                b.aKh += iVar.aJw;
                b.aKi += iVar.aJx;
                b.aKk += iVar.GA;
                b.aKj += iVar.aJn;
                b.aKe++;
                return;
            }
            b.Gp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKb;
        public static int aKc;
        public static int aKd;

        public static void Gp() {
            com.baidu.adp.lib.stats.a fL = q.fL();
            fL.p("action", "imbusy");
            fL.p("totalNum", String.valueOf(aKb));
            fL.p("tfailNum", String.valueOf(aKc));
            fL.p("qfailNum", String.valueOf(aKd));
            BdStatisticsManager.getInstance().performance("im", fL);
            resetData();
        }

        public static void resetData() {
            aKb = 0;
            aKc = 0;
            aKd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKe;
        public static long aKf;
        public static long aKg;
        public static long aKh;
        public static int aKi;
        public static int aKj;
        public static long aKk;

        public static void Gp() {
            com.baidu.adp.lib.stats.a fL = q.fL();
            fL.p("action", "imcost");
            fL.p("dect", String.valueOf(aKf));
            fL.p("dlsize", String.valueOf(aKg));
            fL.p("dbt", String.valueOf(aKh));
            fL.p("pnum", String.valueOf(aKi));
            fL.p("reqcost", String.valueOf(aKk));
            fL.p("cpu", String.valueOf(aKj));
            fL.p("totalNum", String.valueOf(aKe));
            BdStatisticsManager.getInstance().performance("im", fL);
            Gw();
        }

        public static void Gw() {
            aKe = 0;
            aKf = 0L;
            aKg = 0L;
            aKh = 0L;
            aKi = 0;
            aKj = 0;
        }
    }
}
