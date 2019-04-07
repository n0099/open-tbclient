package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cqJ = 100;
    public static int cqK = 10;

    public static void ape() {
        if (m.apg().aph()) {
            if (b.cqO > cqK) {
                b.apa();
            }
            if (a.cqL > cqK) {
                a.apa();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cqL++;
        if (z2) {
            a.cqM++;
        } else if (z3) {
            a.cqN++;
        }
        if (a.cqL > cqJ) {
            a.apa();
        }
    }

    public void c(f fVar) {
        if (m.apg().aph()) {
            if (b.cqO < cqJ) {
                b.cqP += fVar.Cv;
                b.cqQ += fVar.cqh;
                b.cqR += fVar.cqi;
                b.cqS += fVar.cqj;
                b.cqU += fVar.Oi;
                b.cqT += fVar.cqk;
                b.cqO++;
                return;
            }
            b.apa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cqL;
        public static int cqM;
        public static int cqN;

        public static void apa() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imbusy");
            jC.append("totalNum", String.valueOf(cqL));
            jC.append("tfailNum", String.valueOf(cqM));
            jC.append("qfailNum", String.valueOf(cqN));
            BdStatisticsManager.getInstance().performance("im", jC);
            resetData();
        }

        public static void resetData() {
            cqL = 0;
            cqM = 0;
            cqN = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cqO;
        public static long cqP;
        public static long cqQ;
        public static long cqR;
        public static int cqS;
        public static int cqT;
        public static long cqU;

        public static void apa() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imcost");
            jC.append("dect", String.valueOf(cqP));
            jC.append("dlsize", String.valueOf(cqQ));
            jC.append("dbt", String.valueOf(cqR));
            jC.append("pnum", String.valueOf(cqS));
            jC.append("reqcost", String.valueOf(cqU));
            jC.append("cpu", String.valueOf(cqT));
            jC.append("totalNum", String.valueOf(cqO));
            BdStatisticsManager.getInstance().performance("im", jC);
            apf();
        }

        public static void apf() {
            cqO = 0;
            cqP = 0L;
            cqQ = 0L;
            cqR = 0L;
            cqS = 0;
            cqT = 0;
        }
    }
}
