package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int cyQ = 100;
    public static int cyR = 10;

    public static void aui() {
        if (m.auk().aul()) {
            if (b.cyV > cyR) {
                b.aue();
            }
            if (a.cyS > cyR) {
                a.aue();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cyS++;
        if (z2) {
            a.cyT++;
        } else if (z3) {
            a.cyU++;
        }
        if (a.cyS > cyQ) {
            a.aue();
        }
    }

    public void c(f fVar) {
        if (m.auk().aul()) {
            if (b.cyV < cyQ) {
                b.cyW += fVar.Af;
                b.cyX += fVar.cyo;
                b.cyY += fVar.cyp;
                b.cyZ += fVar.cyq;
                b.czb += fVar.LR;
                b.cza += fVar.cyr;
                b.cyV++;
                return;
            }
            b.aue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cyS;
        public static int cyT;
        public static int cyU;

        public static void aue() {
            com.baidu.adp.lib.stats.a iw = l.iw();
            iw.append("action", "imbusy");
            iw.append("totalNum", String.valueOf(cyS));
            iw.append("tfailNum", String.valueOf(cyT));
            iw.append("qfailNum", String.valueOf(cyU));
            BdStatisticsManager.getInstance().performance("im", iw);
            resetData();
        }

        public static void resetData() {
            cyS = 0;
            cyT = 0;
            cyU = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cyV;
        public static long cyW;
        public static long cyX;
        public static long cyY;
        public static int cyZ;
        public static int cza;
        public static long czb;

        public static void aue() {
            com.baidu.adp.lib.stats.a iw = l.iw();
            iw.append("action", "imcost");
            iw.append("dect", String.valueOf(cyW));
            iw.append("dlsize", String.valueOf(cyX));
            iw.append("dbt", String.valueOf(cyY));
            iw.append("pnum", String.valueOf(cyZ));
            iw.append("reqcost", String.valueOf(czb));
            iw.append("cpu", String.valueOf(cza));
            iw.append("totalNum", String.valueOf(cyV));
            BdStatisticsManager.getInstance().performance("im", iw);
            auj();
        }

        public static void auj() {
            cyV = 0;
            cyW = 0L;
            cyX = 0L;
            cyY = 0L;
            cyZ = 0;
            cza = 0;
        }
    }
}
