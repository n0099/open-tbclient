package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class n extends q {
    public static int byQ = 100;
    public static int byR = 10;

    public static void NO() {
        if (r.NQ().NR()) {
            if (b.byV > byR) {
                b.NI();
            }
            if (a.byS > byR) {
                a.NI();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.byS++;
        if (z2) {
            a.byT++;
        } else if (z3) {
            a.byU++;
        }
        if (a.byS > byQ) {
            a.NI();
        }
    }

    public void c(i iVar) {
        if (r.NQ().NR()) {
            if (b.byV < byQ) {
                b.byW += iVar.aiY;
                b.byX += iVar.asS;
                b.byY += iVar.byn;
                b.byZ += iVar.byo;
                b.bzb += iVar.aus;
                b.bza += iVar.bye;
                b.byV++;
                return;
            }
            b.NI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int byS;
        public static int byT;
        public static int byU;

        public static void NI() {
            com.baidu.adp.lib.stats.a nn = q.nn();
            nn.append("action", "imbusy");
            nn.append("totalNum", String.valueOf(byS));
            nn.append("tfailNum", String.valueOf(byT));
            nn.append("qfailNum", String.valueOf(byU));
            BdStatisticsManager.getInstance().performance("im", nn);
            resetData();
        }

        public static void resetData() {
            byS = 0;
            byT = 0;
            byU = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int byV;
        public static long byW;
        public static long byX;
        public static long byY;
        public static int byZ;
        public static int bza;
        public static long bzb;

        public static void NI() {
            com.baidu.adp.lib.stats.a nn = q.nn();
            nn.append("action", "imcost");
            nn.append("dect", String.valueOf(byW));
            nn.append("dlsize", String.valueOf(byX));
            nn.append("dbt", String.valueOf(byY));
            nn.append("pnum", String.valueOf(byZ));
            nn.append("reqcost", String.valueOf(bzb));
            nn.append("cpu", String.valueOf(bza));
            nn.append("totalNum", String.valueOf(byV));
            BdStatisticsManager.getInstance().performance("im", nn);
            NP();
        }

        public static void NP() {
            byV = 0;
            byW = 0L;
            byX = 0L;
            byY = 0L;
            byZ = 0;
            bza = 0;
        }
    }
}
