package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes2.dex */
public class j extends l {
    public static int eSf = 100;
    public static int eSg = 10;

    public static void bul() {
        if (m.bun().buo()) {
            if (b.eSk > eSg) {
                b.buh();
            }
            if (a.eSh > eSg) {
                a.buh();
            }
        }
    }

    public static void f(boolean z, boolean z2, boolean z3) {
        a.eSh++;
        if (z2) {
            a.eSi++;
        } else if (z3) {
            a.eSj++;
        }
        if (a.eSh > eSf) {
            a.buh();
        }
    }

    public void c(f fVar) {
        if (m.bun().buo()) {
            if (b.eSk < eSf) {
                b.eSl += fVar.KT;
                b.eSm += fVar.eRB;
                b.eSn += fVar.eRC;
                b.eSo += fVar.eRD;
                b.eSq += fVar.costTime;
                b.eSp += fVar.eRE;
                b.eSk++;
                return;
            }
            b.buh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        public static int eSh;
        public static int eSi;
        public static int eSj;

        public static void buh() {
            com.baidu.adp.lib.stats.a mN = l.mN();
            mN.append("action", "imbusy");
            mN.append("totalNum", String.valueOf(eSh));
            mN.append("tfailNum", String.valueOf(eSi));
            mN.append("qfailNum", String.valueOf(eSj));
            BdStatisticsManager.getInstance().performance("im", mN);
            resetData();
        }

        public static void resetData() {
            eSh = 0;
            eSi = 0;
            eSj = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        public static int eSk;
        public static long eSl;
        public static long eSm;
        public static long eSn;
        public static int eSo;
        public static int eSp;
        public static long eSq;

        public static void buh() {
            com.baidu.adp.lib.stats.a mN = l.mN();
            mN.append("action", "imcost");
            mN.append("dect", String.valueOf(eSl));
            mN.append("dlsize", String.valueOf(eSm));
            mN.append("dbt", String.valueOf(eSn));
            mN.append("pnum", String.valueOf(eSo));
            mN.append("reqcost", String.valueOf(eSq));
            mN.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eSp));
            mN.append("totalNum", String.valueOf(eSk));
            BdStatisticsManager.getInstance().performance("im", mN);
            bum();
        }

        public static void bum() {
            eSk = 0;
            eSl = 0L;
            eSm = 0L;
            eSn = 0L;
            eSo = 0;
            eSp = 0;
        }
    }
}
