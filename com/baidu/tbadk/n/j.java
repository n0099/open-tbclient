package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int dEt = 100;
    public static int dEu = 10;

    public static void aRo() {
        if (m.aRq().aRr()) {
            if (b.dEy > dEu) {
                b.aRk();
            }
            if (a.dEv > dEu) {
                a.aRk();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.dEv++;
        if (z2) {
            a.dEw++;
        } else if (z3) {
            a.dEx++;
        }
        if (a.dEv > dEt) {
            a.aRk();
        }
    }

    public void c(f fVar) {
        if (m.aRq().aRr()) {
            if (b.dEy < dEt) {
                b.dEz += fVar.qB;
                b.dEA += fVar.dDP;
                b.dEB += fVar.dDQ;
                b.dEC += fVar.dDR;
                b.dEE += fVar.costTime;
                b.dED += fVar.dDS;
                b.dEy++;
                return;
            }
            b.aRk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int dEv;
        public static int dEw;
        public static int dEx;

        public static void aRk() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imbusy");
            gs.append("totalNum", String.valueOf(dEv));
            gs.append("tfailNum", String.valueOf(dEw));
            gs.append("qfailNum", String.valueOf(dEx));
            BdStatisticsManager.getInstance().performance("im", gs);
            resetData();
        }

        public static void resetData() {
            dEv = 0;
            dEw = 0;
            dEx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long dEA;
        public static long dEB;
        public static int dEC;
        public static int dED;
        public static long dEE;
        public static int dEy;
        public static long dEz;

        public static void aRk() {
            com.baidu.adp.lib.stats.a gs = l.gs();
            gs.append("action", "imcost");
            gs.append("dect", String.valueOf(dEz));
            gs.append("dlsize", String.valueOf(dEA));
            gs.append("dbt", String.valueOf(dEB));
            gs.append("pnum", String.valueOf(dEC));
            gs.append("reqcost", String.valueOf(dEE));
            gs.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(dED));
            gs.append("totalNum", String.valueOf(dEy));
            BdStatisticsManager.getInstance().performance("im", gs);
            aRp();
        }

        public static void aRp() {
            dEy = 0;
            dEz = 0L;
            dEA = 0L;
            dEB = 0L;
            dEC = 0;
            dED = 0;
        }
    }
}
