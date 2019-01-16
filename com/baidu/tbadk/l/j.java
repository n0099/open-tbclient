package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bgV = 100;
    public static int bgW = 10;

    public static void PB() {
        if (m.PD().PE()) {
            if (b.bha > bgW) {
                b.Px();
            }
            if (a.bgX > bgW) {
                a.Px();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bgX++;
        if (z2) {
            a.bgY++;
        } else if (z3) {
            a.bgZ++;
        }
        if (a.bgX > bgV) {
            a.Px();
        }
    }

    public void c(f fVar) {
        if (m.PD().PE()) {
            if (b.bha < bgV) {
                b.bhb += fVar.Cw;
                b.bhc += fVar.bgt;
                b.bhd += fVar.bgu;
                b.bhe += fVar.bgv;
                b.bhg += fVar.NW;
                b.bhf += fVar.bgw;
                b.bha++;
                return;
            }
            b.Px();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bgX;
        public static int bgY;
        public static int bgZ;

        public static void Px() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imbusy");
            jB.append("totalNum", String.valueOf(bgX));
            jB.append("tfailNum", String.valueOf(bgY));
            jB.append("qfailNum", String.valueOf(bgZ));
            BdStatisticsManager.getInstance().performance("im", jB);
            resetData();
        }

        public static void resetData() {
            bgX = 0;
            bgY = 0;
            bgZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bha;
        public static long bhb;
        public static long bhc;
        public static long bhd;
        public static int bhe;
        public static int bhf;
        public static long bhg;

        public static void Px() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imcost");
            jB.append("dect", String.valueOf(bhb));
            jB.append("dlsize", String.valueOf(bhc));
            jB.append("dbt", String.valueOf(bhd));
            jB.append("pnum", String.valueOf(bhe));
            jB.append("reqcost", String.valueOf(bhg));
            jB.append("cpu", String.valueOf(bhf));
            jB.append("totalNum", String.valueOf(bha));
            BdStatisticsManager.getInstance().performance("im", jB);
            PC();
        }

        public static void PC() {
            bha = 0;
            bhb = 0L;
            bhc = 0L;
            bhd = 0L;
            bhe = 0;
            bhf = 0;
        }
    }
}
