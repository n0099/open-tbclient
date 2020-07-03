package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eBk = 100;
    public static int eBl = 10;

    public static void bhN() {
        if (m.bhP().bhQ()) {
            if (b.eBp > eBl) {
                b.bhJ();
            }
            if (a.eBm > eBl) {
                a.bhJ();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.eBm++;
        if (z2) {
            a.eBn++;
        } else if (z3) {
            a.eBo++;
        }
        if (a.eBm > eBk) {
            a.bhJ();
        }
    }

    public void c(f fVar) {
        if (m.bhP().bhQ()) {
            if (b.eBp < eBk) {
                b.eBq += fVar.Kp;
                b.eBr += fVar.eAG;
                b.eBs += fVar.eAH;
                b.eBt += fVar.eAI;
                b.eBv += fVar.costTime;
                b.eBu += fVar.eAJ;
                b.eBp++;
                return;
            }
            b.bhJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eBm;
        public static int eBn;
        public static int eBo;

        public static void bhJ() {
            com.baidu.adp.lib.stats.a lo = l.lo();
            lo.append("action", "imbusy");
            lo.append("totalNum", String.valueOf(eBm));
            lo.append("tfailNum", String.valueOf(eBn));
            lo.append("qfailNum", String.valueOf(eBo));
            BdStatisticsManager.getInstance().performance("im", lo);
            resetData();
        }

        public static void resetData() {
            eBm = 0;
            eBn = 0;
            eBo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eBp;
        public static long eBq;
        public static long eBr;
        public static long eBs;
        public static int eBt;
        public static int eBu;
        public static long eBv;

        public static void bhJ() {
            com.baidu.adp.lib.stats.a lo = l.lo();
            lo.append("action", "imcost");
            lo.append("dect", String.valueOf(eBq));
            lo.append("dlsize", String.valueOf(eBr));
            lo.append("dbt", String.valueOf(eBs));
            lo.append("pnum", String.valueOf(eBt));
            lo.append("reqcost", String.valueOf(eBv));
            lo.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eBu));
            lo.append("totalNum", String.valueOf(eBp));
            BdStatisticsManager.getInstance().performance("im", lo);
            bhO();
        }

        public static void bhO() {
            eBp = 0;
            eBq = 0L;
            eBr = 0L;
            eBs = 0L;
            eBt = 0;
            eBu = 0;
        }
    }
}
