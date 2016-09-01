package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aCC = 100;
    public static int aCD = 10;

    public static void Gn() {
        if (aa.Gp().Gq()) {
            if (b.aCH > aCD) {
                b.Gh();
            }
            if (a.aCE > aCD) {
                a.Gh();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aCE++;
        if (z2) {
            a.aCF++;
        } else if (z3) {
            a.aCG++;
        }
        if (a.aCE > aCC) {
            a.Gh();
        }
    }

    public void c(p pVar) {
        if (aa.Gp().Gq()) {
            if (b.aCH < aCC) {
                b.aCI += pVar.nU;
                b.aCJ += pVar.yU;
                b.aCK += pVar.aBY;
                b.aCL += pVar.aBZ;
                b.aCN += pVar.AA;
                b.aCM += pVar.aBP;
                b.aCH++;
                return;
            }
            b.Gh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aCE;
        public static int aCF;
        public static int aCG;

        public static void Gh() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imbusy");
            eB.q("totalNum", String.valueOf(aCE));
            eB.q("tfailNum", String.valueOf(aCF));
            eB.q("qfailNum", String.valueOf(aCG));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            resetData();
        }

        public static void resetData() {
            aCE = 0;
            aCF = 0;
            aCG = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aCH;
        public static long aCI;
        public static long aCJ;
        public static long aCK;
        public static int aCL;
        public static int aCM;
        public static long aCN;

        public static void Gh() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imcost");
            eB.q("dect", String.valueOf(aCI));
            eB.q("dlsize", String.valueOf(aCJ));
            eB.q("dbt", String.valueOf(aCK));
            eB.q("pnum", String.valueOf(aCL));
            eB.q("reqcost", String.valueOf(aCN));
            eB.q("cpu", String.valueOf(aCM));
            eB.q("totalNum", String.valueOf(aCH));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            Go();
        }

        public static void Go() {
            aCH = 0;
            aCI = 0L;
            aCJ = 0L;
            aCK = 0L;
            aCL = 0;
            aCM = 0;
        }
    }
}
