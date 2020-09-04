package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eSj = 100;
    public static int eSk = 10;

    public static void bum() {
        if (m.buo().bup()) {
            if (b.eSo > eSk) {
                b.bui();
            }
            if (a.eSl > eSk) {
                a.bui();
            }
        }
    }

    public static void f(boolean z, boolean z2, boolean z3) {
        a.eSl++;
        if (z2) {
            a.eSm++;
        } else if (z3) {
            a.eSn++;
        }
        if (a.eSl > eSj) {
            a.bui();
        }
    }

    public void c(f fVar) {
        if (m.buo().bup()) {
            if (b.eSo < eSj) {
                b.eSp += fVar.KT;
                b.eSq += fVar.eRF;
                b.eSr += fVar.eRG;
                b.eSs += fVar.eRH;
                b.eSu += fVar.costTime;
                b.eSt += fVar.eRI;
                b.eSo++;
                return;
            }
            b.bui();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eSl;
        public static int eSm;
        public static int eSn;

        public static void bui() {
            com.baidu.adp.lib.stats.a mN = l.mN();
            mN.append("action", "imbusy");
            mN.append("totalNum", String.valueOf(eSl));
            mN.append("tfailNum", String.valueOf(eSm));
            mN.append("qfailNum", String.valueOf(eSn));
            BdStatisticsManager.getInstance().performance("im", mN);
            resetData();
        }

        public static void resetData() {
            eSl = 0;
            eSm = 0;
            eSn = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eSo;
        public static long eSp;
        public static long eSq;
        public static long eSr;
        public static int eSs;
        public static int eSt;
        public static long eSu;

        public static void bui() {
            com.baidu.adp.lib.stats.a mN = l.mN();
            mN.append("action", "imcost");
            mN.append("dect", String.valueOf(eSp));
            mN.append("dlsize", String.valueOf(eSq));
            mN.append("dbt", String.valueOf(eSr));
            mN.append("pnum", String.valueOf(eSs));
            mN.append("reqcost", String.valueOf(eSu));
            mN.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eSt));
            mN.append("totalNum", String.valueOf(eSo));
            BdStatisticsManager.getInstance().performance("im", mN);
            bun();
        }

        public static void bun() {
            eSo = 0;
            eSp = 0L;
            eSq = 0L;
            eSr = 0L;
            eSs = 0;
            eSt = 0;
        }
    }
}
