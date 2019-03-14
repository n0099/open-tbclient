package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cqH = 100;
    public static int cqI = 10;

    public static void aph() {
        if (m.apk().apl()) {
            if (b.cqM > cqI) {
                b.apd();
            }
            if (a.cqJ > cqI) {
                a.apd();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cqJ++;
        if (z2) {
            a.cqK++;
        } else if (z3) {
            a.cqL++;
        }
        if (a.cqJ > cqH) {
            a.apd();
        }
    }

    public void c(f fVar) {
        if (m.apk().apl()) {
            if (b.cqM < cqH) {
                b.cqN += fVar.Cw;
                b.cqO += fVar.cqf;
                b.cqP += fVar.cqg;
                b.cqQ += fVar.cqh;
                b.cqS += fVar.Oi;
                b.cqR += fVar.cqi;
                b.cqM++;
                return;
            }
            b.apd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cqJ;
        public static int cqK;
        public static int cqL;

        public static void apd() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imbusy");
            jC.append("totalNum", String.valueOf(cqJ));
            jC.append("tfailNum", String.valueOf(cqK));
            jC.append("qfailNum", String.valueOf(cqL));
            BdStatisticsManager.getInstance().performance("im", jC);
            resetData();
        }

        public static void resetData() {
            cqJ = 0;
            cqK = 0;
            cqL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cqM;
        public static long cqN;
        public static long cqO;
        public static long cqP;
        public static int cqQ;
        public static int cqR;
        public static long cqS;

        public static void apd() {
            com.baidu.adp.lib.stats.a jC = l.jC();
            jC.append("action", "imcost");
            jC.append("dect", String.valueOf(cqN));
            jC.append("dlsize", String.valueOf(cqO));
            jC.append("dbt", String.valueOf(cqP));
            jC.append("pnum", String.valueOf(cqQ));
            jC.append("reqcost", String.valueOf(cqS));
            jC.append("cpu", String.valueOf(cqR));
            jC.append("totalNum", String.valueOf(cqM));
            BdStatisticsManager.getInstance().performance("im", jC);
            apj();
        }

        public static void apj() {
            cqM = 0;
            cqN = 0L;
            cqO = 0L;
            cqP = 0L;
            cqQ = 0;
            cqR = 0;
        }
    }
}
