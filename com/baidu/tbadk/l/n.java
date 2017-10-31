package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJU = 100;
    public static int aJV = 10;

    public static void Gg() {
        if (r.Gi().Gj()) {
            if (b.aJZ > aJV) {
                b.Ga();
            }
            if (a.aJW > aJV) {
                a.Ga();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aJW++;
        if (z2) {
            a.aJX++;
        } else if (z3) {
            a.aJY++;
        }
        if (a.aJW > aJU) {
            a.Ga();
        }
    }

    public void c(i iVar) {
        if (r.Gi().Gj()) {
            if (b.aJZ < aJU) {
                b.aKa += iVar.uK;
                b.aKb += iVar.EM;
                b.aKc += iVar.aJr;
                b.aKd += iVar.aJs;
                b.aKf += iVar.Gn;
                b.aKe += iVar.aJi;
                b.aJZ++;
                return;
            }
            b.Ga();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aJW;
        public static int aJX;
        public static int aJY;

        public static void Ga() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aJW));
            fK.p("tfailNum", String.valueOf(aJX));
            fK.p("qfailNum", String.valueOf(aJY));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aJW = 0;
            aJX = 0;
            aJY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aJZ;
        public static long aKa;
        public static long aKb;
        public static long aKc;
        public static int aKd;
        public static int aKe;
        public static long aKf;

        public static void Ga() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aKa));
            fK.p("dlsize", String.valueOf(aKb));
            fK.p("dbt", String.valueOf(aKc));
            fK.p("pnum", String.valueOf(aKd));
            fK.p("reqcost", String.valueOf(aKf));
            fK.p("cpu", String.valueOf(aKe));
            fK.p("totalNum", String.valueOf(aJZ));
            BdStatisticsManager.getInstance().performance("im", fK);
            Gh();
        }

        public static void Gh() {
            aJZ = 0;
            aKa = 0L;
            aKb = 0L;
            aKc = 0L;
            aKd = 0;
            aKe = 0;
        }
    }
}
