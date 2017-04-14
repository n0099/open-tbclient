package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aGP = 100;
    public static int aGQ = 10;

    public static void GE() {
        if (aa.GG().GH()) {
            if (b.aGU > aGQ) {
                b.Gy();
            }
            if (a.aGR > aGQ) {
                a.Gy();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aGR++;
        if (z2) {
            a.aGS++;
        } else if (z3) {
            a.aGT++;
        }
        if (a.aGR > aGP) {
            a.Gy();
        }
    }

    public void c(p pVar) {
        if (aa.GG().GH()) {
            if (b.aGU < aGP) {
                b.aGV += pVar.vg;
                b.aGW += pVar.FA;
                b.aGX += pVar.aGm;
                b.aGY += pVar.aGn;
                b.aHa += pVar.He;
                b.aGZ += pVar.aGd;
                b.aGU++;
                return;
            }
            b.Gy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aGR;
        public static int aGS;
        public static int aGT;

        public static void Gy() {
            com.baidu.adp.lib.stats.c fM = w.fM();
            fM.p("action", "imbusy");
            fM.p("totalNum", String.valueOf(aGR));
            fM.p("tfailNum", String.valueOf(aGS));
            fM.p("qfailNum", String.valueOf(aGT));
            BdStatisticsManager.getInstance().performance("im", fM);
            resetData();
        }

        public static void resetData() {
            aGR = 0;
            aGS = 0;
            aGT = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aGU;
        public static long aGV;
        public static long aGW;
        public static long aGX;
        public static int aGY;
        public static int aGZ;
        public static long aHa;

        public static void Gy() {
            com.baidu.adp.lib.stats.c fM = w.fM();
            fM.p("action", "imcost");
            fM.p("dect", String.valueOf(aGV));
            fM.p("dlsize", String.valueOf(aGW));
            fM.p("dbt", String.valueOf(aGX));
            fM.p("pnum", String.valueOf(aGY));
            fM.p("reqcost", String.valueOf(aHa));
            fM.p("cpu", String.valueOf(aGZ));
            fM.p("totalNum", String.valueOf(aGU));
            BdStatisticsManager.getInstance().performance("im", fM);
            GF();
        }

        public static void GF() {
            aGU = 0;
            aGV = 0L;
            aGW = 0L;
            aGX = 0L;
            aGY = 0;
            aGZ = 0;
        }
    }
}
