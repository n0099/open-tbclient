package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cyR = 100;
    public static int cyS = 10;

    public static void aui() {
        if (m.auk().aul()) {
            if (b.cyW > cyS) {
                b.aue();
            }
            if (a.cyT > cyS) {
                a.aue();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cyT++;
        if (z2) {
            a.cyU++;
        } else if (z3) {
            a.cyV++;
        }
        if (a.cyT > cyR) {
            a.aue();
        }
    }

    public void c(f fVar) {
        if (m.auk().aul()) {
            if (b.cyW < cyR) {
                b.cyX += fVar.Ae;
                b.cyY += fVar.cyp;
                b.cyZ += fVar.cyq;
                b.cza += fVar.cyr;
                b.czc += fVar.LQ;
                b.czb += fVar.cys;
                b.cyW++;
                return;
            }
            b.aue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cyT;
        public static int cyU;
        public static int cyV;

        public static void aue() {
            com.baidu.adp.lib.stats.a iw = l.iw();
            iw.append("action", "imbusy");
            iw.append("totalNum", String.valueOf(cyT));
            iw.append("tfailNum", String.valueOf(cyU));
            iw.append("qfailNum", String.valueOf(cyV));
            BdStatisticsManager.getInstance().performance("im", iw);
            resetData();
        }

        public static void resetData() {
            cyT = 0;
            cyU = 0;
            cyV = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cyW;
        public static long cyX;
        public static long cyY;
        public static long cyZ;
        public static int cza;
        public static int czb;
        public static long czc;

        public static void aue() {
            com.baidu.adp.lib.stats.a iw = l.iw();
            iw.append("action", "imcost");
            iw.append("dect", String.valueOf(cyX));
            iw.append("dlsize", String.valueOf(cyY));
            iw.append("dbt", String.valueOf(cyZ));
            iw.append("pnum", String.valueOf(cza));
            iw.append("reqcost", String.valueOf(czc));
            iw.append("cpu", String.valueOf(czb));
            iw.append("totalNum", String.valueOf(cyW));
            BdStatisticsManager.getInstance().performance("im", iw);
            auj();
        }

        public static void auj() {
            cyW = 0;
            cyX = 0L;
            cyY = 0L;
            cyZ = 0L;
            cza = 0;
            czb = 0;
        }
    }
}
