package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class j extends l {
    public static int eef = 100;
    public static int eeg = 10;

    public static void aZw() {
        if (m.aZy().aZz()) {
            if (b.eek > eeg) {
                b.aZs();
            }
            if (a.eeh > eeg) {
                a.aZs();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.eeh++;
        if (z2) {
            a.eei++;
        } else if (z3) {
            a.eej++;
        }
        if (a.eeh > eef) {
            a.aZs();
        }
    }

    public void c(f fVar) {
        if (m.aZy().aZz()) {
            if (b.eek < eef) {
                b.eel += fVar.JF;
                b.eem += fVar.edB;
                b.een += fVar.edC;
                b.eeo += fVar.edD;
                b.eeq += fVar.costTime;
                b.eep += fVar.edE;
                b.eek++;
                return;
            }
            b.aZs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int eeh;
        public static int eei;
        public static int eej;

        public static void aZs() {
            com.baidu.adp.lib.stats.a kW = l.kW();
            kW.append("action", "imbusy");
            kW.append("totalNum", String.valueOf(eeh));
            kW.append("tfailNum", String.valueOf(eei));
            kW.append("qfailNum", String.valueOf(eej));
            BdStatisticsManager.getInstance().performance("im", kW);
            resetData();
        }

        public static void resetData() {
            eeh = 0;
            eei = 0;
            eej = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int eek;
        public static long eel;
        public static long eem;
        public static long een;
        public static int eeo;
        public static int eep;
        public static long eeq;

        public static void aZs() {
            com.baidu.adp.lib.stats.a kW = l.kW();
            kW.append("action", "imcost");
            kW.append("dect", String.valueOf(eel));
            kW.append("dlsize", String.valueOf(eem));
            kW.append("dbt", String.valueOf(een));
            kW.append("pnum", String.valueOf(eeo));
            kW.append("reqcost", String.valueOf(eeq));
            kW.append(com.baidu.fsg.face.base.b.c.i, String.valueOf(eep));
            kW.append("totalNum", String.valueOf(eek));
            BdStatisticsManager.getInstance().performance("im", kW);
            aZx();
        }

        public static void aZx() {
            eek = 0;
            eel = 0L;
            eem = 0L;
            een = 0L;
            eeo = 0;
            eep = 0;
        }
    }
}
