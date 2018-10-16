package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bbU = 100;
    public static int bbV = 10;

    public static void NV() {
        if (m.NX().NY()) {
            if (b.bbZ > bbV) {
                b.NR();
            }
            if (a.bbW > bbV) {
                a.NR();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bbW++;
        if (z2) {
            a.bbX++;
        } else if (z3) {
            a.bbY++;
        }
        if (a.bbW > bbU) {
            a.NR();
        }
    }

    public void c(f fVar) {
        if (m.NX().NY()) {
            if (b.bbZ < bbU) {
                b.bca += fVar.Ct;
                b.bcb += fVar.bbs;
                b.bcc += fVar.bbt;
                b.bcd += fVar.bbu;
                b.bcf += fVar.NI;
                b.bce += fVar.bbv;
                b.bbZ++;
                return;
            }
            b.NR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bbW;
        public static int bbX;
        public static int bbY;

        public static void NR() {
            com.baidu.adp.lib.stats.a jD = l.jD();
            jD.append("action", "imbusy");
            jD.append("totalNum", String.valueOf(bbW));
            jD.append("tfailNum", String.valueOf(bbX));
            jD.append("qfailNum", String.valueOf(bbY));
            BdStatisticsManager.getInstance().performance("im", jD);
            resetData();
        }

        public static void resetData() {
            bbW = 0;
            bbX = 0;
            bbY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bbZ;
        public static long bca;
        public static long bcb;
        public static long bcc;
        public static int bcd;
        public static int bce;
        public static long bcf;

        public static void NR() {
            com.baidu.adp.lib.stats.a jD = l.jD();
            jD.append("action", "imcost");
            jD.append("dect", String.valueOf(bca));
            jD.append("dlsize", String.valueOf(bcb));
            jD.append("dbt", String.valueOf(bcc));
            jD.append("pnum", String.valueOf(bcd));
            jD.append("reqcost", String.valueOf(bcf));
            jD.append("cpu", String.valueOf(bce));
            jD.append("totalNum", String.valueOf(bbZ));
            BdStatisticsManager.getInstance().performance("im", jD);
            NW();
        }

        public static void NW() {
            bbZ = 0;
            bca = 0L;
            bcb = 0L;
            bcc = 0L;
            bcd = 0;
            bce = 0;
        }
    }
}
