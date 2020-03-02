package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dDQ = 100;
    public static int dDR = 10;

    public static void aRj() {
        if (m.aRl().aRm()) {
            if (b.dDV > dDR) {
                b.aRf();
            }
            if (a.dDS > dDR) {
                a.aRf();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dDS++;
        if (z2) {
            a.dDT++;
        } else if (z3) {
            a.dDU++;
        }
        if (a.dDS > dDQ) {
            a.aRf();
        }
    }

    public void c(f fVar) {
        if (m.aRl().aRm()) {
            if (b.dDV < dDQ) {
                b.dDW += fVar.qC;
                b.dDX += fVar.dDo;
                b.dDY += fVar.dDp;
                b.dDZ += fVar.dDq;
                b.dEb += fVar.costTime;
                b.dEa += fVar.dDr;
                b.dDV++;
                return;
            }
            b.aRf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dDS;
        public static int dDT;
        public static int dDU;

        public static void aRf() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imbusy");
            gs.append("totalNum", String.valueOf(dDS));
            gs.append("tfailNum", String.valueOf(dDT));
            gs.append("qfailNum", String.valueOf(dDU));
            BdStatisticsManager.getInstance().performance("im", gs);
            resetData();
        }

        public static void resetData() {
            dDS = 0;
            dDT = 0;
            dDU = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int dDV;
        public static long dDW;
        public static long dDX;
        public static long dDY;
        public static int dDZ;
        public static int dEa;
        public static long dEb;

        public static void aRf() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imcost");
            gs.append("dect", String.valueOf(dDW));
            gs.append("dlsize", String.valueOf(dDX));
            gs.append("dbt", String.valueOf(dDY));
            gs.append("pnum", String.valueOf(dDZ));
            gs.append("reqcost", String.valueOf(dEb));
            gs.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dEa));
            gs.append("totalNum", String.valueOf(dDV));
            BdStatisticsManager.getInstance().performance("im", gs);
            aRk();
        }

        public static void aRk() {
            dDV = 0;
            dDW = 0L;
            dDX = 0L;
            dDY = 0L;
            dDZ = 0;
            dEa = 0;
        }
    }
}
