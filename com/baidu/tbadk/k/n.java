package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJk = 100;
    public static int aJl = 10;

    public static void FU() {
        if (r.FW().FX()) {
            if (b.aJp > aJl) {
                b.FO();
            }
            if (a.aJm > aJl) {
                a.FO();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aJm++;
        if (z2) {
            a.aJn++;
        } else if (z3) {
            a.aJo++;
        }
        if (a.aJm > aJk) {
            a.FO();
        }
    }

    public void c(i iVar) {
        if (r.FW().FX()) {
            if (b.aJp < aJk) {
                b.aJq += iVar.uK;
                b.aJr += iVar.Fb;
                b.aJs += iVar.aIH;
                b.aJt += iVar.aII;
                b.aJv += iVar.GC;
                b.aJu += iVar.aIy;
                b.aJp++;
                return;
            }
            b.FO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aJm;
        public static int aJn;
        public static int aJo;

        public static void FO() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aJm));
            fK.p("tfailNum", String.valueOf(aJn));
            fK.p("qfailNum", String.valueOf(aJo));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aJm = 0;
            aJn = 0;
            aJo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aJp;
        public static long aJq;
        public static long aJr;
        public static long aJs;
        public static int aJt;
        public static int aJu;
        public static long aJv;

        public static void FO() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aJq));
            fK.p("dlsize", String.valueOf(aJr));
            fK.p("dbt", String.valueOf(aJs));
            fK.p("pnum", String.valueOf(aJt));
            fK.p("reqcost", String.valueOf(aJv));
            fK.p("cpu", String.valueOf(aJu));
            fK.p("totalNum", String.valueOf(aJp));
            BdStatisticsManager.getInstance().performance("im", fK);
            FV();
        }

        public static void FV() {
            aJp = 0;
            aJq = 0L;
            aJr = 0L;
            aJs = 0L;
            aJt = 0;
            aJu = 0;
        }
    }
}
