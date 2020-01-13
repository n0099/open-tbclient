package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dzN = 100;
    public static int dzO = 10;

    public static void aOR() {
        if (m.aOT().aOU()) {
            if (b.dzS > dzO) {
                b.aON();
            }
            if (a.dzP > dzO) {
                a.aON();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dzP++;
        if (z2) {
            a.dzQ++;
        } else if (z3) {
            a.dzR++;
        }
        if (a.dzP > dzN) {
            a.aON();
        }
    }

    public void c(f fVar) {
        if (m.aOT().aOU()) {
            if (b.dzS < dzN) {
                b.dzT += fVar.qB;
                b.dzU += fVar.dzl;
                b.dzV += fVar.dzm;
                b.dzW += fVar.dzn;
                b.dzY += fVar.costTime;
                b.dzX += fVar.dzo;
                b.dzS++;
                return;
            }
            b.aON();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dzP;
        public static int dzQ;
        public static int dzR;

        public static void aON() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imbusy");
            gs.append("totalNum", String.valueOf(dzP));
            gs.append("tfailNum", String.valueOf(dzQ));
            gs.append("qfailNum", String.valueOf(dzR));
            BdStatisticsManager.getInstance().performance("im", gs);
            resetData();
        }

        public static void resetData() {
            dzP = 0;
            dzQ = 0;
            dzR = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int dzS;
        public static long dzT;
        public static long dzU;
        public static long dzV;
        public static int dzW;
        public static int dzX;
        public static long dzY;

        public static void aON() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imcost");
            gs.append("dect", String.valueOf(dzT));
            gs.append("dlsize", String.valueOf(dzU));
            gs.append("dbt", String.valueOf(dzV));
            gs.append("pnum", String.valueOf(dzW));
            gs.append("reqcost", String.valueOf(dzY));
            gs.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dzX));
            gs.append("totalNum", String.valueOf(dzS));
            BdStatisticsManager.getInstance().performance("im", gs);
            aOS();
        }

        public static void aOS() {
            dzS = 0;
            dzT = 0L;
            dzU = 0L;
            dzV = 0L;
            dzW = 0;
            dzX = 0;
        }
    }
}
