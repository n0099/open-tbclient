package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class w extends z {
    public static int aHW = 100;
    public static int aHX = 10;

    public static void FZ() {
        if (aa.Gb().Gc()) {
            if (b.aIb > aHX) {
                b.FT();
            }
            if (a.aHY > aHX) {
                a.FT();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aHY++;
        if (z2) {
            a.aHZ++;
        } else if (z3) {
            a.aIa++;
        }
        if (a.aHY > aHW) {
            a.FT();
        }
    }

    public void c(p pVar) {
        if (aa.Gb().Gc()) {
            if (b.aIb < aHW) {
                b.aIc += pVar.vl;
                b.aId += pVar.FD;
                b.aIe += pVar.aHt;
                b.aIf += pVar.aHu;
                b.aIh += pVar.Hf;
                b.aIg += pVar.aHk;
                b.aIb++;
                return;
            }
            b.FT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aHY;
        public static int aHZ;
        public static int aIa;

        public static void FT() {
            com.baidu.adp.lib.stats.c fM = w.fM();
            fM.p("action", "imbusy");
            fM.p("totalNum", String.valueOf(aHY));
            fM.p("tfailNum", String.valueOf(aHZ));
            fM.p("qfailNum", String.valueOf(aIa));
            BdStatisticsManager.getInstance().performance("im", fM);
            resetData();
        }

        public static void resetData() {
            aHY = 0;
            aHZ = 0;
            aIa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aIb;
        public static long aIc;
        public static long aId;
        public static long aIe;
        public static int aIf;
        public static int aIg;
        public static long aIh;

        public static void FT() {
            com.baidu.adp.lib.stats.c fM = w.fM();
            fM.p("action", "imcost");
            fM.p("dect", String.valueOf(aIc));
            fM.p("dlsize", String.valueOf(aId));
            fM.p("dbt", String.valueOf(aIe));
            fM.p("pnum", String.valueOf(aIf));
            fM.p("reqcost", String.valueOf(aIh));
            fM.p("cpu", String.valueOf(aIg));
            fM.p("totalNum", String.valueOf(aIb));
            BdStatisticsManager.getInstance().performance("im", fM);
            Ga();
        }

        public static void Ga() {
            aIb = 0;
            aIc = 0L;
            aId = 0L;
            aIe = 0L;
            aIf = 0;
            aIg = 0;
        }
    }
}
