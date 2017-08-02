package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int aJe = 100;
    public static int aJf = 10;

    public static void Gp() {
        if (r.Gr().Gs()) {
            if (b.aJj > aJf) {
                b.Gj();
            }
            if (a.aJg > aJf) {
                a.Gj();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aJg++;
        if (z2) {
            a.aJh++;
        } else if (z3) {
            a.aJi++;
        }
        if (a.aJg > aJe) {
            a.Gj();
        }
    }

    public void c(i iVar) {
        if (r.Gr().Gs()) {
            if (b.aJj < aJe) {
                b.aJk += iVar.vm;
                b.aJl += iVar.FD;
                b.aJm += iVar.aIB;
                b.aJn += iVar.aIC;
                b.aJp += iVar.Hf;
                b.aJo += iVar.aIs;
                b.aJj++;
                return;
            }
            b.Gj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aJg;
        public static int aJh;
        public static int aJi;

        public static void Gj() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imbusy");
            fK.p("totalNum", String.valueOf(aJg));
            fK.p("tfailNum", String.valueOf(aJh));
            fK.p("qfailNum", String.valueOf(aJi));
            BdStatisticsManager.getInstance().performance("im", fK);
            resetData();
        }

        public static void resetData() {
            aJg = 0;
            aJh = 0;
            aJi = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aJj;
        public static long aJk;
        public static long aJl;
        public static long aJm;
        public static int aJn;
        public static int aJo;
        public static long aJp;

        public static void Gj() {
            com.baidu.adp.lib.stats.a fK = q.fK();
            fK.p("action", "imcost");
            fK.p("dect", String.valueOf(aJk));
            fK.p("dlsize", String.valueOf(aJl));
            fK.p("dbt", String.valueOf(aJm));
            fK.p("pnum", String.valueOf(aJn));
            fK.p("reqcost", String.valueOf(aJp));
            fK.p("cpu", String.valueOf(aJo));
            fK.p("totalNum", String.valueOf(aJj));
            BdStatisticsManager.getInstance().performance("im", fK);
            Gq();
        }

        public static void Gq() {
            aJj = 0;
            aJk = 0L;
            aJl = 0L;
            aJm = 0L;
            aJn = 0;
            aJo = 0;
        }
    }
}
