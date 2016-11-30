package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends z {
    public static int aCW = 100;
    public static int aCX = 10;

    public static void Gs() {
        if (aa.Gu().Gv()) {
            if (b.aDb > aCX) {
                b.Gm();
            }
            if (a.aCY > aCX) {
                a.Gm();
            }
        }
    }

    public static void b(boolean z, boolean z2, boolean z3) {
        a.aCY++;
        if (z2) {
            a.aCZ++;
        } else if (z3) {
            a.aDa++;
        }
        if (a.aCY > aCW) {
            a.Gm();
        }
    }

    public void c(p pVar) {
        if (aa.Gu().Gv()) {
            if (b.aDb < aCW) {
                b.aDc += pVar.nV;
                b.aDd += pVar.yU;
                b.aDe += pVar.aCs;
                b.aDf += pVar.aCt;
                b.aDh += pVar.AA;
                b.aDg += pVar.aCj;
                b.aDb++;
                return;
            }
            b.Gm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aCY;
        public static int aCZ;
        public static int aDa;

        public static void Gm() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imbusy");
            eB.q("totalNum", String.valueOf(aCY));
            eB.q("tfailNum", String.valueOf(aCZ));
            eB.q("qfailNum", String.valueOf(aDa));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            resetData();
        }

        public static void resetData() {
            aCY = 0;
            aCZ = 0;
            aDa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aDb;
        public static long aDc;
        public static long aDd;
        public static long aDe;
        public static int aDf;
        public static int aDg;
        public static long aDh;

        public static void Gm() {
            com.baidu.adp.lib.stats.d eB = w.eB();
            eB.q("action", "imcost");
            eB.q("dect", String.valueOf(aDc));
            eB.q("dlsize", String.valueOf(aDd));
            eB.q("dbt", String.valueOf(aDe));
            eB.q("pnum", String.valueOf(aDf));
            eB.q("reqcost", String.valueOf(aDh));
            eB.q("cpu", String.valueOf(aDg));
            eB.q("totalNum", String.valueOf(aDb));
            com.baidu.adp.lib.stats.a.eI().a("im", eB);
            Gt();
        }

        public static void Gt() {
            aDb = 0;
            aDc = 0L;
            aDd = 0L;
            aDe = 0L;
            aDf = 0;
            aDg = 0;
        }
    }
}
