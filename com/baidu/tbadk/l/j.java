package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bgh = 100;
    public static int bgi = 10;

    public static void Pi() {
        if (m.Pk().Pl()) {
            if (b.bgm > bgi) {
                b.Pe();
            }
            if (a.bgj > bgi) {
                a.Pe();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bgj++;
        if (z2) {
            a.bgk++;
        } else if (z3) {
            a.bgl++;
        }
        if (a.bgj > bgh) {
            a.Pe();
        }
    }

    public void c(f fVar) {
        if (m.Pk().Pl()) {
            if (b.bgm < bgh) {
                b.bgn += fVar.Cw;
                b.bgo += fVar.bfF;
                b.bgp += fVar.bfG;
                b.bgq += fVar.bfH;
                b.bgt += fVar.NL;
                b.bgr += fVar.bfI;
                b.bgm++;
                return;
            }
            b.Pe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bgj;
        public static int bgk;
        public static int bgl;

        public static void Pe() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imbusy");
            jB.append("totalNum", String.valueOf(bgj));
            jB.append("tfailNum", String.valueOf(bgk));
            jB.append("qfailNum", String.valueOf(bgl));
            BdStatisticsManager.getInstance().performance("im", jB);
            resetData();
        }

        public static void resetData() {
            bgj = 0;
            bgk = 0;
            bgl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bgm;
        public static long bgn;
        public static long bgo;
        public static long bgp;
        public static int bgq;
        public static int bgr;
        public static long bgt;

        public static void Pe() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imcost");
            jB.append("dect", String.valueOf(bgn));
            jB.append("dlsize", String.valueOf(bgo));
            jB.append("dbt", String.valueOf(bgp));
            jB.append("pnum", String.valueOf(bgq));
            jB.append("reqcost", String.valueOf(bgt));
            jB.append("cpu", String.valueOf(bgr));
            jB.append("totalNum", String.valueOf(bgm));
            BdStatisticsManager.getInstance().performance("im", jB);
            Pj();
        }

        public static void Pj() {
            bgm = 0;
            bgn = 0L;
            bgo = 0L;
            bgp = 0L;
            bgq = 0;
            bgr = 0;
        }
    }
}
