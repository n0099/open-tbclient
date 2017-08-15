package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKu = 100;
    public static int aKv = 10;

    public static void Gx() {
        if (r.Gz().GA()) {
            if (b.aKz > aKv) {
                b.Gr();
            }
            if (a.aKw > aKv) {
                a.Gr();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKw++;
        if (z2) {
            a.aKx++;
        } else if (z3) {
            a.aKy++;
        }
        if (a.aKw > aKu) {
            a.Gr();
        }
    }

    public void c(i iVar) {
        if (r.Gz().GA()) {
            if (b.aKz < aKu) {
                b.aKA += iVar.wR;
                b.aKB += iVar.He;
                b.aKC += iVar.aJR;
                b.aKD += iVar.aJS;
                b.aKF += iVar.IH;
                b.aKE += iVar.aJI;
                b.aKz++;
                return;
            }
            b.Gr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKw;
        public static int aKx;
        public static int aKy;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imbusy");
            fV.p("totalNum", String.valueOf(aKw));
            fV.p("tfailNum", String.valueOf(aKx));
            fV.p("qfailNum", String.valueOf(aKy));
            BdStatisticsManager.getInstance().performance("im", fV);
            resetData();
        }

        public static void resetData() {
            aKw = 0;
            aKx = 0;
            aKy = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long aKA;
        public static long aKB;
        public static long aKC;
        public static int aKD;
        public static int aKE;
        public static long aKF;
        public static int aKz;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imcost");
            fV.p("dect", String.valueOf(aKA));
            fV.p("dlsize", String.valueOf(aKB));
            fV.p("dbt", String.valueOf(aKC));
            fV.p("pnum", String.valueOf(aKD));
            fV.p("reqcost", String.valueOf(aKF));
            fV.p("cpu", String.valueOf(aKE));
            fV.p("totalNum", String.valueOf(aKz));
            BdStatisticsManager.getInstance().performance("im", fV);
            Gy();
        }

        public static void Gy() {
            aKz = 0;
            aKA = 0L;
            aKB = 0L;
            aKC = 0L;
            aKD = 0;
            aKE = 0;
        }
    }
}
