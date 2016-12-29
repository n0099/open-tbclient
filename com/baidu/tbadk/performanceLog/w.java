package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aCq = 100;
    public static int aCr = 10;

    public static void FS() {
        if (aa.FU().FV()) {
            if (b.aCv > aCr) {
                b.FM();
            }
            if (a.aCs > aCr) {
                a.FM();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aCs++;
        if (z2) {
            a.aCt++;
        } else if (z3) {
            a.aCu++;
        }
        if (a.aCs > aCq) {
            a.FM();
        }
    }

    public void c(p pVar) {
        if (aa.FU().FV()) {
            if (b.aCv < aCq) {
                b.aCw += pVar.nV;
                b.aCx += pVar.yU;
                b.aCy += pVar.aBM;
                b.aCz += pVar.aBN;
                b.aCB += pVar.AA;
                b.aCA += pVar.aBD;
                b.aCv++;
                return;
            }
            b.FM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aCs;
        public static int aCt;
        public static int aCu;

        public static void FM() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imbusy");
            eB.q("totalNum", String.valueOf(aCs));
            eB.q("tfailNum", String.valueOf(aCt));
            eB.q("qfailNum", String.valueOf(aCu));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            resetData();
        }

        public static void resetData() {
            aCs = 0;
            aCt = 0;
            aCu = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aCA;
        public static long aCB;
        public static int aCv;
        public static long aCw;
        public static long aCx;
        public static long aCy;
        public static int aCz;

        public static void FM() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imcost");
            eB.q("dect", String.valueOf(aCw));
            eB.q("dlsize", String.valueOf(aCx));
            eB.q("dbt", String.valueOf(aCy));
            eB.q("pnum", String.valueOf(aCz));
            eB.q("reqcost", String.valueOf(aCB));
            eB.q("cpu", String.valueOf(aCA));
            eB.q("totalNum", String.valueOf(aCv));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            FT();
        }

        public static void FT() {
            aCv = 0;
            aCw = 0L;
            aCx = 0L;
            aCy = 0L;
            aCz = 0;
            aCA = 0;
        }
    }
}
