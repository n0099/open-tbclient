package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eea = 100;
    public static int eeb = 10;

    public static void aZy() {
        if (m.aZA().aZB()) {
            if (b.eef > eeb) {
                b.aZu();
            }
            if (a.eec > eeb) {
                a.aZu();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.eec++;
        if (z2) {
            a.eed++;
        } else if (z3) {
            a.eee++;
        }
        if (a.eec > eea) {
            a.aZu();
        }
    }

    public void c(f fVar) {
        if (m.aZA().aZB()) {
            if (b.eef < eea) {
                b.eeg += fVar.JC;
                b.eeh += fVar.edw;
                b.eei += fVar.edx;
                b.eej += fVar.edy;
                b.eel += fVar.costTime;
                b.eek += fVar.edz;
                b.eef++;
                return;
            }
            b.aZu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eec;
        public static int eed;
        public static int eee;

        public static void aZu() {
            com.baidu.adp.lib.stats.a kW = l.kW();
            kW.append("action", "imbusy");
            kW.append("totalNum", String.valueOf(eec));
            kW.append("tfailNum", String.valueOf(eed));
            kW.append("qfailNum", String.valueOf(eee));
            BdStatisticsManager.getInstance().performance("im", kW);
            resetData();
        }

        public static void resetData() {
            eec = 0;
            eed = 0;
            eee = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eef;
        public static long eeg;
        public static long eeh;
        public static long eei;
        public static int eej;
        public static int eek;
        public static long eel;

        public static void aZu() {
            com.baidu.adp.lib.stats.a kW = l.kW();
            kW.append("action", "imcost");
            kW.append("dect", String.valueOf(eeg));
            kW.append("dlsize", String.valueOf(eeh));
            kW.append("dbt", String.valueOf(eei));
            kW.append("pnum", String.valueOf(eej));
            kW.append("reqcost", String.valueOf(eel));
            kW.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eek));
            kW.append("totalNum", String.valueOf(eef));
            BdStatisticsManager.getInstance().performance("im", kW);
            aZz();
        }

        public static void aZz() {
            eef = 0;
            eeg = 0L;
            eeh = 0L;
            eei = 0L;
            eej = 0;
            eek = 0;
        }
    }
}
