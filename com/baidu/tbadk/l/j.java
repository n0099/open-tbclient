package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class j extends l {
    public static int aXu = 100;
    public static int aXv = 10;

    public static void LX() {
        if (m.LZ().Ma()) {
            if (b.aXz > aXv) {
                b.LT();
            }
            if (a.aXw > aXv) {
                a.LT();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aXw++;
        if (z2) {
            a.aXx++;
        } else if (z3) {
            a.aXy++;
        }
        if (a.aXw > aXu) {
            a.LT();
        }
    }

    public void c(f fVar) {
        if (m.LZ().Ma()) {
            if (b.aXz < aXu) {
                b.aXA += fVar.BL;
                b.aXB += fVar.aWS;
                b.aXC += fVar.aWT;
                b.aXD += fVar.aWU;
                b.aXF += fVar.Nm;
                b.aXE += fVar.aWV;
                b.aXz++;
                return;
            }
            b.LT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aXw;
        public static int aXx;
        public static int aXy;

        public static void LT() {
            com.baidu.adp.lib.stats.a jo = l.jo();
            jo.append(AuthActivity.ACTION_KEY, "imbusy");
            jo.append("totalNum", String.valueOf(aXw));
            jo.append("tfailNum", String.valueOf(aXx));
            jo.append("qfailNum", String.valueOf(aXy));
            BdStatisticsManager.getInstance().performance("im", jo);
            resetData();
        }

        public static void resetData() {
            aXw = 0;
            aXx = 0;
            aXy = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static long aXA;
        public static long aXB;
        public static long aXC;
        public static int aXD;
        public static int aXE;
        public static long aXF;
        public static int aXz;

        public static void LT() {
            com.baidu.adp.lib.stats.a jo = l.jo();
            jo.append(AuthActivity.ACTION_KEY, "imcost");
            jo.append("dect", String.valueOf(aXA));
            jo.append("dlsize", String.valueOf(aXB));
            jo.append("dbt", String.valueOf(aXC));
            jo.append("pnum", String.valueOf(aXD));
            jo.append("reqcost", String.valueOf(aXF));
            jo.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(aXE));
            jo.append("totalNum", String.valueOf(aXz));
            BdStatisticsManager.getInstance().performance("im", jo);
            LY();
        }

        public static void LY() {
            aXz = 0;
            aXA = 0L;
            aXB = 0L;
            aXC = 0L;
            aXD = 0;
            aXE = 0;
        }
    }
}
