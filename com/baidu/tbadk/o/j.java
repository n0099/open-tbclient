package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cqK = 100;
    public static int cqL = 10;

    public static void ape() {
        if (m.apg().aph()) {
            if (b.cqP > cqL) {
                b.apa();
            }
            if (a.cqM > cqL) {
                a.apa();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cqM++;
        if (z2) {
            a.cqN++;
        } else if (z3) {
            a.cqO++;
        }
        if (a.cqM > cqK) {
            a.apa();
        }
    }

    public void c(f fVar) {
        if (m.apg().aph()) {
            if (b.cqP < cqK) {
                b.cqQ += fVar.Cv;
                b.cqR += fVar.cqi;
                b.cqS += fVar.cqj;
                b.cqT += fVar.cqk;
                b.cqV += fVar.Oi;
                b.cqU += fVar.cql;
                b.cqP++;
                return;
            }
            b.apa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cqM;
        public static int cqN;
        public static int cqO;

        public static void apa() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imbusy");
            jC.append("totalNum", String.valueOf(cqM));
            jC.append("tfailNum", String.valueOf(cqN));
            jC.append("qfailNum", String.valueOf(cqO));
            BdStatisticsManager.getInstance().performance("im", jC);
            resetData();
        }

        public static void resetData() {
            cqM = 0;
            cqN = 0;
            cqO = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cqP;
        public static long cqQ;
        public static long cqR;
        public static long cqS;
        public static int cqT;
        public static int cqU;
        public static long cqV;

        public static void apa() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imcost");
            jC.append("dect", String.valueOf(cqQ));
            jC.append("dlsize", String.valueOf(cqR));
            jC.append("dbt", String.valueOf(cqS));
            jC.append("pnum", String.valueOf(cqT));
            jC.append("reqcost", String.valueOf(cqV));
            jC.append("cpu", String.valueOf(cqU));
            jC.append("totalNum", String.valueOf(cqP));
            BdStatisticsManager.getInstance().performance("im", jC);
            apf();
        }

        public static void apf() {
            cqP = 0;
            cqQ = 0L;
            cqR = 0L;
            cqS = 0L;
            cqT = 0;
            cqU = 0;
        }
    }
}
