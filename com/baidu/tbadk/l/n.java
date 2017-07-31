package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aKt = 100;
    public static int aKu = 10;

    public static void Gx() {
        if (r.Gz().GA()) {
            if (b.aKy > aKu) {
                b.Gr();
            }
            if (a.aKv > aKu) {
                a.Gr();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aKv++;
        if (z2) {
            a.aKw++;
        } else if (z3) {
            a.aKx++;
        }
        if (a.aKv > aKt) {
            a.Gr();
        }
    }

    public void c(i iVar) {
        if (r.Gz().GA()) {
            if (b.aKy < aKt) {
                b.aKz += iVar.wP;
                b.aKA += iVar.Hc;
                b.aKB += iVar.aJQ;
                b.aKC += iVar.aJR;
                b.aKE += iVar.IF;
                b.aKD += iVar.aJH;
                b.aKy++;
                return;
            }
            b.Gr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aKv;
        public static int aKw;
        public static int aKx;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imbusy");
            fV.p("totalNum", String.valueOf(aKv));
            fV.p("tfailNum", String.valueOf(aKw));
            fV.p("qfailNum", String.valueOf(aKx));
            BdStatisticsManager.getInstance().performance("im", fV);
            resetData();
        }

        public static void resetData() {
            aKv = 0;
            aKw = 0;
            aKx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long aKA;
        public static long aKB;
        public static int aKC;
        public static int aKD;
        public static long aKE;
        public static int aKy;
        public static long aKz;

        public static void Gr() {
            com.baidu.adp.lib.stats.a fV = q.fV();
            fV.p("action", "imcost");
            fV.p("dect", String.valueOf(aKz));
            fV.p("dlsize", String.valueOf(aKA));
            fV.p("dbt", String.valueOf(aKB));
            fV.p("pnum", String.valueOf(aKC));
            fV.p("reqcost", String.valueOf(aKE));
            fV.p("cpu", String.valueOf(aKD));
            fV.p("totalNum", String.valueOf(aKy));
            BdStatisticsManager.getInstance().performance("im", fV);
            Gy();
        }

        public static void Gy() {
            aKy = 0;
            aKz = 0L;
            aKA = 0L;
            aKB = 0L;
            aKC = 0;
            aKD = 0;
        }
    }
}
