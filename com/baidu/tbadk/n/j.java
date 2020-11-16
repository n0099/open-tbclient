package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int fuM = 100;
    public static int fuN = 10;

    public static void bBI() {
        if (m.bBK().isSmallFlow()) {
            if (b.fuR > fuN) {
                b.bBE();
            }
            if (a.fuO > fuN) {
                a.bBE();
            }
        }
    }

    public static void g(boolean z, boolean z2, boolean z3) {
        a.fuO++;
        if (z2) {
            a.fuP++;
        } else if (z3) {
            a.fuQ++;
        }
        if (a.fuO > fuM) {
            a.bBE();
        }
    }

    public void c(f fVar) {
        if (m.bBK().isSmallFlow()) {
            if (b.fuR < fuM) {
                b.fuS += fVar.Ls;
                b.fuT += fVar.fui;
                b.fuU += fVar.fuj;
                b.fuV += fVar.fuk;
                b.fuX += fVar.costTime;
                b.fuW += fVar.ful;
                b.fuR++;
                return;
            }
            b.bBE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int fuO;
        public static int fuP;
        public static int fuQ;

        public static void bBE() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imbusy");
            mT.append("totalNum", String.valueOf(fuO));
            mT.append("tfailNum", String.valueOf(fuP));
            mT.append("qfailNum", String.valueOf(fuQ));
            BdStatisticsManager.getInstance().performance("im", mT);
            resetData();
        }

        public static void resetData() {
            fuO = 0;
            fuP = 0;
            fuQ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int fuR;
        public static long fuS;
        public static long fuT;
        public static long fuU;
        public static int fuV;
        public static int fuW;
        public static long fuX;

        public static void bBE() {
            com.baidu.adp.lib.stats.a mT = l.mT();
            mT.append("action", "imcost");
            mT.append("dect", String.valueOf(fuS));
            mT.append("dlsize", String.valueOf(fuT));
            mT.append("dbt", String.valueOf(fuU));
            mT.append("pnum", String.valueOf(fuV));
            mT.append("reqcost", String.valueOf(fuX));
            mT.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(fuW));
            mT.append("totalNum", String.valueOf(fuR));
            BdStatisticsManager.getInstance().performance("im", mT);
            bBJ();
        }

        public static void bBJ() {
            fuR = 0;
            fuS = 0L;
            fuT = 0L;
            fuU = 0L;
            fuV = 0;
            fuW = 0;
        }
    }
}
