package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
/* loaded from: classes.dex */
public class j extends l {
    public static int cBk = 100;
    public static int cBl = 10;

    public static void avF() {
        if (m.avH().avI()) {
            if (b.cBp > cBl) {
                b.avB();
            }
            if (a.cBm > cBl) {
                a.avB();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.cBm++;
        if (z2) {
            a.cBn++;
        } else if (z3) {
            a.cBo++;
        }
        if (a.cBm > cBk) {
            a.avB();
        }
    }

    public void c(f fVar) {
        if (m.avH().avI()) {
            if (b.cBp < cBk) {
                b.cBq += fVar.Ak;
                b.cBr += fVar.cAI;
                b.cBs += fVar.cAJ;
                b.cBt += fVar.cAK;
                b.cBv += fVar.Me;
                b.cBu += fVar.cAL;
                b.cBp++;
                return;
            }
            b.avB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int cBm;
        public static int cBn;
        public static int cBo;

        public static void avB() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imbusy");
            iF.append("totalNum", String.valueOf(cBm));
            iF.append("tfailNum", String.valueOf(cBn));
            iF.append("qfailNum", String.valueOf(cBo));
            BdStatisticsManager.getInstance().performance(IXAdRequestInfo.IMSI, iF);
            resetData();
        }

        public static void resetData() {
            cBm = 0;
            cBn = 0;
            cBo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int cBp;
        public static long cBq;
        public static long cBr;
        public static long cBs;
        public static int cBt;
        public static int cBu;
        public static long cBv;

        public static void avB() {
            com.baidu.adp.lib.stats.a iF = l.iF();
            iF.append("action", "imcost");
            iF.append("dect", String.valueOf(cBq));
            iF.append("dlsize", String.valueOf(cBr));
            iF.append("dbt", String.valueOf(cBs));
            iF.append("pnum", String.valueOf(cBt));
            iF.append("reqcost", String.valueOf(cBv));
            iF.append("cpu", String.valueOf(cBu));
            iF.append("totalNum", String.valueOf(cBp));
            BdStatisticsManager.getInstance().performance(IXAdRequestInfo.IMSI, iF);
            avG();
        }

        public static void avG() {
            cBp = 0;
            cBq = 0L;
            cBr = 0L;
            cBs = 0L;
            cBt = 0;
            cBu = 0;
        }
    }
}
