package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class m extends o {
    public static int aLk = 100;
    public static int aLl = 10;

    public static void GW() {
        if (p.GY().GZ()) {
            if (b.aLp > aLl) {
                b.GO();
            }
            if (a.aLm > aLl) {
                a.GO();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aLm++;
        if (z2) {
            a.aLn++;
        } else if (z3) {
            a.aLo++;
        }
        if (a.aLm > aLk) {
            a.GO();
        }
    }

    public void c(i iVar) {
        if (p.GY().GZ()) {
            if (b.aLp < aLk) {
                b.aLq += iVar.tp;
                b.aLr += iVar.aKH;
                b.aLs += iVar.aKI;
                b.aLt += iVar.aKJ;
                b.aLv += iVar.EE;
                b.aLu += iVar.aKy;
                b.aLp++;
                return;
            }
            b.GO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aLm;
        public static int aLn;
        public static int aLo;

        public static void GO() {
            com.baidu.adp.lib.stats.a fq = o.fq();
            fq.append(AuthActivity.ACTION_KEY, "imbusy");
            fq.append("totalNum", String.valueOf(aLm));
            fq.append("tfailNum", String.valueOf(aLn));
            fq.append("qfailNum", String.valueOf(aLo));
            BdStatisticsManager.getInstance().performance("im", fq);
            resetData();
        }

        public static void resetData() {
            aLm = 0;
            aLn = 0;
            aLo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aLp;
        public static long aLq;
        public static long aLr;
        public static long aLs;
        public static int aLt;
        public static int aLu;
        public static long aLv;

        public static void GO() {
            com.baidu.adp.lib.stats.a fq = o.fq();
            fq.append(AuthActivity.ACTION_KEY, "imcost");
            fq.append("dect", String.valueOf(aLq));
            fq.append("dlsize", String.valueOf(aLr));
            fq.append("dbt", String.valueOf(aLs));
            fq.append("pnum", String.valueOf(aLt));
            fq.append("reqcost", String.valueOf(aLv));
            fq.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(aLu));
            fq.append("totalNum", String.valueOf(aLp));
            BdStatisticsManager.getInstance().performance("im", fq);
            GX();
        }

        public static void GX() {
            aLp = 0;
            aLq = 0L;
            aLr = 0L;
            aLs = 0L;
            aLt = 0;
            aLu = 0;
        }
    }
}
