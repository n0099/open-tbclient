package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKv = 100;
    public static int aKw = 10;

    public static void Gx() {
        if (r.Gz().GA()) {
            if (b.aKA > aKw) {
                b.Gr();
            }
            if (a.aKx > aKw) {
                a.Gr();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKx++;
        if (z2) {
            a.aKy++;
        } else if (z3) {
            a.aKz++;
        }
        if (a.aKx > aKv) {
            a.Gr();
        }
    }

    public void c(i iVar) {
        if (r.Gz().GA()) {
            if (b.aKA < aKv) {
                b.aKB += iVar.wR;
                b.aKC += iVar.He;
                b.aKD += iVar.aJS;
                b.aKE += iVar.aJT;
                b.aKG += iVar.IH;
                b.aKF += iVar.aJJ;
                b.aKA++;
                return;
            }
            b.Gr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKx;
        public static int aKy;
        public static int aKz;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imbusy");
            fV.p("totalNum", String.valueOf(aKx));
            fV.p("tfailNum", String.valueOf(aKy));
            fV.p("qfailNum", String.valueOf(aKz));
            BdStatisticsManager.getInstance().performance("im", fV);
            resetData();
        }

        public static void resetData() {
            aKx = 0;
            aKy = 0;
            aKz = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aKA;
        public static long aKB;
        public static long aKC;
        public static long aKD;
        public static int aKE;
        public static int aKF;
        public static long aKG;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imcost");
            fV.p("dect", String.valueOf(aKB));
            fV.p("dlsize", String.valueOf(aKC));
            fV.p("dbt", String.valueOf(aKD));
            fV.p("pnum", String.valueOf(aKE));
            fV.p("reqcost", String.valueOf(aKG));
            fV.p("cpu", String.valueOf(aKF));
            fV.p("totalNum", String.valueOf(aKA));
            BdStatisticsManager.getInstance().performance("im", fV);
            Gy();
        }

        public static void Gy() {
            aKA = 0;
            aKB = 0L;
            aKC = 0L;
            aKD = 0L;
            aKE = 0;
            aKF = 0;
        }
    }
}
