package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class m extends o {
    public static int aLj = 100;
    public static int aLk = 10;

    public static void GY() {
        if (p.Ha().Hb()) {
            if (b.aLo > aLk) {
                b.GQ();
            }
            if (a.aLl > aLk) {
                a.GQ();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aLl++;
        if (z2) {
            a.aLm++;
        } else if (z3) {
            a.aLn++;
        }
        if (a.aLl > aLj) {
            a.GQ();
        }
    }

    public void c(i iVar) {
        if (p.Ha().Hb()) {
            if (b.aLo < aLj) {
                b.aLp += iVar.tq;
                b.aLq += iVar.aKG;
                b.aLr += iVar.aKH;
                b.aLs += iVar.aKI;
                b.aLu += iVar.EI;
                b.aLt += iVar.aKx;
                b.aLo++;
                return;
            }
            b.GQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aLl;
        public static int aLm;
        public static int aLn;

        public static void GQ() {
            com.baidu.adp.lib.stats.a fq = o.fq();
            fq.append(AuthActivity.ACTION_KEY, "imbusy");
            fq.append("totalNum", String.valueOf(aLl));
            fq.append("tfailNum", String.valueOf(aLm));
            fq.append("qfailNum", String.valueOf(aLn));
            BdStatisticsManager.getInstance().performance("im", fq);
            resetData();
        }

        public static void resetData() {
            aLl = 0;
            aLm = 0;
            aLn = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aLo;
        public static long aLp;
        public static long aLq;
        public static long aLr;
        public static int aLs;
        public static int aLt;
        public static long aLu;

        public static void GQ() {
            com.baidu.adp.lib.stats.a fq = o.fq();
            fq.append(AuthActivity.ACTION_KEY, "imcost");
            fq.append("dect", String.valueOf(aLp));
            fq.append("dlsize", String.valueOf(aLq));
            fq.append("dbt", String.valueOf(aLr));
            fq.append("pnum", String.valueOf(aLs));
            fq.append("reqcost", String.valueOf(aLu));
            fq.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(aLt));
            fq.append("totalNum", String.valueOf(aLo));
            BdStatisticsManager.getInstance().performance("im", fq);
            GZ();
        }

        public static void GZ() {
            aLo = 0;
            aLp = 0L;
            aLq = 0L;
            aLr = 0L;
            aLs = 0;
            aLt = 0;
        }
    }
}
