package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aGR = 100;
    public static int aGS = 10;

    public static void GE() {
        if (aa.GG().GH()) {
            if (b.aGW > aGS) {
                b.Gy();
            }
            if (a.aGT > aGS) {
                a.Gy();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aGT++;
        if (z2) {
            a.aGU++;
        } else if (z3) {
            a.aGV++;
        }
        if (a.aGT > aGR) {
            a.Gy();
        }
    }

    public void c(p pVar) {
        if (aa.GG().GH()) {
            if (b.aGW < aGR) {
                b.aGX += pVar.vl;
                b.aGY += pVar.FD;
                b.aGZ += pVar.aGo;
                b.aHa += pVar.aGp;
                b.aHc += pVar.Hg;
                b.aHb += pVar.aGf;
                b.aGW++;
                return;
            }
            b.Gy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aGT;
        public static int aGU;
        public static int aGV;

        public static void Gy() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imbusy");
            fN.p("totalNum", String.valueOf(aGT));
            fN.p("tfailNum", String.valueOf(aGU));
            fN.p("qfailNum", String.valueOf(aGV));
            BdStatisticsManager.getInstance().performance("im", fN);
            resetData();
        }

        public static void resetData() {
            aGT = 0;
            aGU = 0;
            aGV = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aGW;
        public static long aGX;
        public static long aGY;
        public static long aGZ;
        public static int aHa;
        public static int aHb;
        public static long aHc;

        public static void Gy() {
            com.baidu.adp.lib.stats.c fN = w.fN();
            fN.p("action", "imcost");
            fN.p("dect", String.valueOf(aGX));
            fN.p("dlsize", String.valueOf(aGY));
            fN.p("dbt", String.valueOf(aGZ));
            fN.p("pnum", String.valueOf(aHa));
            fN.p("reqcost", String.valueOf(aHc));
            fN.p("cpu", String.valueOf(aHb));
            fN.p("totalNum", String.valueOf(aGW));
            BdStatisticsManager.getInstance().performance("im", fN);
            GF();
        }

        public static void GF() {
            aGW = 0;
            aGX = 0L;
            aGY = 0L;
            aGZ = 0L;
            aHa = 0;
            aHb = 0;
        }
    }
}
