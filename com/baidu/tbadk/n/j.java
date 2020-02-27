package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dDP = 100;
    public static int dDQ = 10;

    public static void aRh() {
        if (m.aRj().aRk()) {
            if (b.dDU > dDQ) {
                b.aRd();
            }
            if (a.dDR > dDQ) {
                a.aRd();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dDR++;
        if (z2) {
            a.dDS++;
        } else if (z3) {
            a.dDT++;
        }
        if (a.dDR > dDP) {
            a.aRd();
        }
    }

    public void c(f fVar) {
        if (m.aRj().aRk()) {
            if (b.dDU < dDP) {
                b.dDV += fVar.qC;
                b.dDW += fVar.dDn;
                b.dDX += fVar.dDo;
                b.dDY += fVar.dDp;
                b.dEa += fVar.costTime;
                b.dDZ += fVar.dDq;
                b.dDU++;
                return;
            }
            b.aRd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dDR;
        public static int dDS;
        public static int dDT;

        public static void aRd() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imbusy");
            gs.append("totalNum", String.valueOf(dDR));
            gs.append("tfailNum", String.valueOf(dDS));
            gs.append("qfailNum", String.valueOf(dDT));
            BdStatisticsManager.getInstance().performance("im", gs);
            resetData();
        }

        public static void resetData() {
            dDR = 0;
            dDS = 0;
            dDT = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int dDU;
        public static long dDV;
        public static long dDW;
        public static long dDX;
        public static int dDY;
        public static int dDZ;
        public static long dEa;

        public static void aRd() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imcost");
            gs.append("dect", String.valueOf(dDV));
            gs.append("dlsize", String.valueOf(dDW));
            gs.append("dbt", String.valueOf(dDX));
            gs.append("pnum", String.valueOf(dDY));
            gs.append("reqcost", String.valueOf(dEa));
            gs.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dDZ));
            gs.append("totalNum", String.valueOf(dDU));
            BdStatisticsManager.getInstance().performance("im", gs);
            aRi();
        }

        public static void aRi() {
            dDU = 0;
            dDV = 0L;
            dDW = 0L;
            dDX = 0L;
            dDY = 0;
            dDZ = 0;
        }
    }
}
