package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int bgW = 100;
    public static int bgX = 10;

    public static void PB() {
        if (m.PD().PE()) {
            if (b.bhb > bgX) {
                b.Px();
            }
            if (a.bgY > bgX) {
                a.Px();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.bgY++;
        if (z2) {
            a.bgZ++;
        } else if (z3) {
            a.bha++;
        }
        if (a.bgY > bgW) {
            a.Px();
        }
    }

    public void c(f fVar) {
        if (m.PD().PE()) {
            if (b.bhb < bgW) {
                b.bhc += fVar.Cw;
                b.bhd += fVar.bgu;
                b.bhe += fVar.bgv;
                b.bhf += fVar.bgw;
                b.bhh += fVar.NW;
                b.bhg += fVar.bgx;
                b.bhb++;
                return;
            }
            b.Px();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bgY;
        public static int bgZ;
        public static int bha;

        public static void Px() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imbusy");
            jB.append("totalNum", String.valueOf(bgY));
            jB.append("tfailNum", String.valueOf(bgZ));
            jB.append("qfailNum", String.valueOf(bha));
            BdStatisticsManager.getInstance().performance("im", jB);
            resetData();
        }

        public static void resetData() {
            bgY = 0;
            bgZ = 0;
            bha = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bhb;
        public static long bhc;
        public static long bhd;
        public static long bhe;
        public static int bhf;
        public static int bhg;
        public static long bhh;

        public static void Px() {
            com.baidu.adp.lib.stats.a jB = l.jB();
            jB.append("action", "imcost");
            jB.append("dect", String.valueOf(bhc));
            jB.append("dlsize", String.valueOf(bhd));
            jB.append("dbt", String.valueOf(bhe));
            jB.append("pnum", String.valueOf(bhf));
            jB.append("reqcost", String.valueOf(bhh));
            jB.append("cpu", String.valueOf(bhg));
            jB.append("totalNum", String.valueOf(bhb));
            BdStatisticsManager.getInstance().performance("im", jB);
            PC();
        }

        public static void PC() {
            bhb = 0;
            bhc = 0L;
            bhd = 0L;
            bhe = 0L;
            bhf = 0;
            bhg = 0;
        }
    }
}
