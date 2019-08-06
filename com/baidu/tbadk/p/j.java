package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes.dex */
public class j extends l {
    public static int cAo = 100;
    public static int cAp = 10;

    public static void avt() {
        if (m.avv().avw()) {
            if (b.cAt > cAp) {
                b.avp();
            }
            if (a.cAq > cAp) {
                a.avp();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cAq++;
        if (z2) {
            a.cAr++;
        } else if (z3) {
            a.cAs++;
        }
        if (a.cAq > cAo) {
            a.avp();
        }
    }

    public void c(f fVar) {
        if (m.avv().avw()) {
            if (b.cAt < cAo) {
                b.cAu += fVar.Ak;
                b.cAv += fVar.czM;
                b.cAw += fVar.czN;
                b.cAx += fVar.czO;
                b.cAz += fVar.Me;
                b.cAy += fVar.czP;
                b.cAt++;
                return;
            }
            b.avp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cAq;
        public static int cAr;
        public static int cAs;

        public static void avp() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imbusy");
            iF.append("totalNum", String.valueOf(cAq));
            iF.append("tfailNum", String.valueOf(cAr));
            iF.append("qfailNum", String.valueOf(cAs));
            BdStatisticsManager.getInstance().performance(IXAdRequestInfo.IMSI, iF);
            resetData();
        }

        public static void resetData() {
            cAq = 0;
            cAr = 0;
            cAs = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cAt;
        public static long cAu;
        public static long cAv;
        public static long cAw;
        public static int cAx;
        public static int cAy;
        public static long cAz;

        public static void avp() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imcost");
            iF.append("dect", String.valueOf(cAu));
            iF.append("dlsize", String.valueOf(cAv));
            iF.append("dbt", String.valueOf(cAw));
            iF.append("pnum", String.valueOf(cAx));
            iF.append("reqcost", String.valueOf(cAz));
            iF.append("cpu", String.valueOf(cAy));
            iF.append("totalNum", String.valueOf(cAt));
            BdStatisticsManager.getInstance().performance(IXAdRequestInfo.IMSI, iF);
            avu();
        }

        public static void avu() {
            cAt = 0;
            cAu = 0L;
            cAv = 0L;
            cAw = 0L;
            cAx = 0;
            cAy = 0;
        }
    }
}
