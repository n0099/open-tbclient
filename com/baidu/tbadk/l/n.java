package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJW = 100;
    public static int aJX = 10;

    public static void Gv() {
        if (r.Gx().Gy()) {
            if (b.aKb > aJX) {
                b.Gp();
            }
            if (a.aJY > aJX) {
                a.Gp();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aJY++;
        if (z2) {
            a.aJZ++;
        } else if (z3) {
            a.aKa++;
        }
        if (a.aJY > aJW) {
            a.Gp();
        }
    }

    public void c(i iVar) {
        if (r.Gx().Gy()) {
            if (b.aKb < aJW) {
                b.aKc += iVar.uH;
                b.aKd += iVar.EY;
                b.aKe += iVar.aJt;
                b.aKf += iVar.aJu;
                b.aKh += iVar.GA;
                b.aKg += iVar.aJk;
                b.aKb++;
                return;
            }
            b.Gp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aJY;
        public static int aJZ;
        public static int aKa;

        public static void Gp() {
            com.baidu.adp.lib.stats.a fL = q.fL();
            fL.p("action", "imbusy");
            fL.p("totalNum", String.valueOf(aJY));
            fL.p("tfailNum", String.valueOf(aJZ));
            fL.p("qfailNum", String.valueOf(aKa));
            BdStatisticsManager.getInstance().performance("im", fL);
            resetData();
        }

        public static void resetData() {
            aJY = 0;
            aJZ = 0;
            aKa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKb;
        public static long aKc;
        public static long aKd;
        public static long aKe;
        public static int aKf;
        public static int aKg;
        public static long aKh;

        public static void Gp() {
            com.baidu.adp.lib.stats.a fL = q.fL();
            fL.p("action", "imcost");
            fL.p("dect", String.valueOf(aKc));
            fL.p("dlsize", String.valueOf(aKd));
            fL.p("dbt", String.valueOf(aKe));
            fL.p("pnum", String.valueOf(aKf));
            fL.p("reqcost", String.valueOf(aKh));
            fL.p("cpu", String.valueOf(aKg));
            fL.p("totalNum", String.valueOf(aKb));
            BdStatisticsManager.getInstance().performance("im", fL);
            Gw();
        }

        public static void Gw() {
            aKb = 0;
            aKc = 0L;
            aKd = 0L;
            aKe = 0L;
            aKf = 0;
            aKg = 0;
        }
    }
}
