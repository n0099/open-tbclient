package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int ess = 100;
    public static int est = 10;

    public static void bfG() {
        if (m.bfI().bfJ()) {
            if (b.esx > est) {
                b.bfC();
            }
            if (a.esu > est) {
                a.bfC();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.esu++;
        if (z2) {
            a.esv++;
        } else if (z3) {
            a.esw++;
        }
        if (a.esu > ess) {
            a.bfC();
        }
    }

    public void c(f fVar) {
        if (m.bfI().bfJ()) {
            if (b.esx < ess) {
                b.esy += fVar.JP;
                b.esz += fVar.erO;
                b.esA += fVar.erP;
                b.esB += fVar.erQ;
                b.esD += fVar.costTime;
                b.esC += fVar.erR;
                b.esx++;
                return;
            }
            b.bfC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int esu;
        public static int esv;
        public static int esw;

        public static void bfC() {
            com.baidu.adp.lib.stats.a kY = l.kY();
            kY.append("action", "imbusy");
            kY.append("totalNum", String.valueOf(esu));
            kY.append("tfailNum", String.valueOf(esv));
            kY.append("qfailNum", String.valueOf(esw));
            BdStatisticsManager.getInstance().performance("im", kY);
            resetData();
        }

        public static void resetData() {
            esu = 0;
            esv = 0;
            esw = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long esA;
        public static int esB;
        public static int esC;
        public static long esD;
        public static int esx;
        public static long esy;
        public static long esz;

        public static void bfC() {
            com.baidu.adp.lib.stats.a kY = l.kY();
            kY.append("action", "imcost");
            kY.append("dect", String.valueOf(esy));
            kY.append("dlsize", String.valueOf(esz));
            kY.append("dbt", String.valueOf(esA));
            kY.append("pnum", String.valueOf(esB));
            kY.append("reqcost", String.valueOf(esD));
            kY.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(esC));
            kY.append("totalNum", String.valueOf(esx));
            BdStatisticsManager.getInstance().performance("im", kY);
            bfH();
        }

        public static void bfH() {
            esx = 0;
            esy = 0L;
            esz = 0L;
            esA = 0L;
            esB = 0;
            esC = 0;
        }
    }
}
