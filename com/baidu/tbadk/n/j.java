package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dEd = 100;
    public static int dEe = 10;

    public static void aRk() {
        if (m.aRm().aRn()) {
            if (b.dEi > dEe) {
                b.aRg();
            }
            if (a.dEf > dEe) {
                a.aRg();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dEf++;
        if (z2) {
            a.dEg++;
        } else if (z3) {
            a.dEh++;
        }
        if (a.dEf > dEd) {
            a.aRg();
        }
    }

    public void c(f fVar) {
        if (m.aRm().aRn()) {
            if (b.dEi < dEd) {
                b.dEj += fVar.qC;
                b.dEk += fVar.dDB;
                b.dEl += fVar.dDC;
                b.dEm += fVar.dDD;
                b.dEo += fVar.costTime;
                b.dEn += fVar.dDE;
                b.dEi++;
                return;
            }
            b.aRg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dEf;
        public static int dEg;
        public static int dEh;

        public static void aRg() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imbusy");
            gs.append("totalNum", String.valueOf(dEf));
            gs.append("tfailNum", String.valueOf(dEg));
            gs.append("qfailNum", String.valueOf(dEh));
            BdStatisticsManager.getInstance().performance("im", gs);
            resetData();
        }

        public static void resetData() {
            dEf = 0;
            dEg = 0;
            dEh = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int dEi;
        public static long dEj;
        public static long dEk;
        public static long dEl;
        public static int dEm;
        public static int dEn;
        public static long dEo;

        public static void aRg() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imcost");
            gs.append("dect", String.valueOf(dEj));
            gs.append("dlsize", String.valueOf(dEk));
            gs.append("dbt", String.valueOf(dEl));
            gs.append("pnum", String.valueOf(dEm));
            gs.append("reqcost", String.valueOf(dEo));
            gs.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dEn));
            gs.append("totalNum", String.valueOf(dEi));
            BdStatisticsManager.getInstance().performance("im", gs);
            aRl();
        }

        public static void aRl() {
            dEi = 0;
            dEj = 0L;
            dEk = 0L;
            dEl = 0L;
            dEm = 0;
            dEn = 0;
        }
    }
}
