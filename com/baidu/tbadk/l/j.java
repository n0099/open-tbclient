package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bgk = 100;
    public static int bgl = 10;

    public static void Pj() {
        if (m.Pl().Pm()) {
            if (b.bgp > bgl) {
                b.Pf();
            }
            if (a.bgm > bgl) {
                a.Pf();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bgm++;
        if (z2) {
            a.bgn++;
        } else if (z3) {
            a.bgo++;
        }
        if (a.bgm > bgk) {
            a.Pf();
        }
    }

    public void c(f fVar) {
        if (m.Pl().Pm()) {
            if (b.bgp < bgk) {
                b.bgq += fVar.Cw;
                b.bgr += fVar.bfI;
                b.bgt += fVar.bfJ;
                b.bgu += fVar.bfK;
                b.bgw += fVar.NL;
                b.bgv += fVar.bfL;
                b.bgp++;
                return;
            }
            b.Pf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bgm;
        public static int bgn;
        public static int bgo;

        public static void Pf() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imbusy");
            jB.append("totalNum", String.valueOf(bgm));
            jB.append("tfailNum", String.valueOf(bgn));
            jB.append("qfailNum", String.valueOf(bgo));
            BdStatisticsManager.getInstance().performance("im", jB);
            resetData();
        }

        public static void resetData() {
            bgm = 0;
            bgn = 0;
            bgo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bgp;
        public static long bgq;
        public static long bgr;
        public static long bgt;
        public static int bgu;
        public static int bgv;
        public static long bgw;

        public static void Pf() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imcost");
            jB.append("dect", String.valueOf(bgq));
            jB.append("dlsize", String.valueOf(bgr));
            jB.append("dbt", String.valueOf(bgt));
            jB.append("pnum", String.valueOf(bgu));
            jB.append("reqcost", String.valueOf(bgw));
            jB.append("cpu", String.valueOf(bgv));
            jB.append("totalNum", String.valueOf(bgp));
            BdStatisticsManager.getInstance().performance("im", jB);
            Pk();
        }

        public static void Pk() {
            bgp = 0;
            bgq = 0L;
            bgr = 0L;
            bgt = 0L;
            bgu = 0;
            bgv = 0;
        }
    }
}
