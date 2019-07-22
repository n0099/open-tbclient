package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cAh = 100;
    public static int cAi = 10;

    public static void avr() {
        if (m.avt().avu()) {
            if (b.cAm > cAi) {
                b.avn();
            }
            if (a.cAj > cAi) {
                a.avn();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cAj++;
        if (z2) {
            a.cAk++;
        } else if (z3) {
            a.cAl++;
        }
        if (a.cAj > cAh) {
            a.avn();
        }
    }

    public void c(f fVar) {
        if (m.avt().avu()) {
            if (b.cAm < cAh) {
                b.cAn += fVar.Ak;
                b.cAo += fVar.czF;
                b.cAp += fVar.czG;
                b.cAq += fVar.czH;
                b.cAs += fVar.Me;
                b.cAr += fVar.czI;
                b.cAm++;
                return;
            }
            b.avn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cAj;
        public static int cAk;
        public static int cAl;

        public static void avn() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imbusy");
            iF.append("totalNum", String.valueOf(cAj));
            iF.append("tfailNum", String.valueOf(cAk));
            iF.append("qfailNum", String.valueOf(cAl));
            BdStatisticsManager.getInstance().performance("im", iF);
            resetData();
        }

        public static void resetData() {
            cAj = 0;
            cAk = 0;
            cAl = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cAm;
        public static long cAn;
        public static long cAo;
        public static long cAp;
        public static int cAq;
        public static int cAr;
        public static long cAs;

        public static void avn() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imcost");
            iF.append("dect", String.valueOf(cAn));
            iF.append("dlsize", String.valueOf(cAo));
            iF.append("dbt", String.valueOf(cAp));
            iF.append("pnum", String.valueOf(cAq));
            iF.append("reqcost", String.valueOf(cAs));
            iF.append("cpu", String.valueOf(cAr));
            iF.append("totalNum", String.valueOf(cAm));
            BdStatisticsManager.getInstance().performance("im", iF);
            avs();
        }

        public static void avs() {
            cAm = 0;
            cAn = 0L;
            cAo = 0L;
            cAp = 0L;
            cAq = 0;
            cAr = 0;
        }
    }
}
