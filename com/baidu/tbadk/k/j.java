package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class j extends l {
    public static int aTi = 100;
    public static int aTj = 10;

    public static void Kq() {
        if (m.Ks().Kt()) {
            if (b.aTn > aTj) {
                b.Km();
            }
            if (a.aTk > aTj) {
                a.Km();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aTk++;
        if (z2) {
            a.aTl++;
        } else if (z3) {
            a.aTm++;
        }
        if (a.aTk > aTi) {
            a.Km();
        }
    }

    public void c(f fVar) {
        if (m.Ks().Kt()) {
            if (b.aTn < aTi) {
                b.aTo += fVar.zw;
                b.aTp += fVar.aSG;
                b.aTq += fVar.aSH;
                b.aTr += fVar.aSI;
                b.aTt += fVar.KO;
                b.aTs += fVar.aSJ;
                b.aTn++;
                return;
            }
            b.Km();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aTk;
        public static int aTl;
        public static int aTm;

        public static void Km() {
            com.baidu.adp.lib.stats.a ih = l.ih();
            ih.append(AuthActivity.ACTION_KEY, "imbusy");
            ih.append("totalNum", String.valueOf(aTk));
            ih.append("tfailNum", String.valueOf(aTl));
            ih.append("qfailNum", String.valueOf(aTm));
            BdStatisticsManager.getInstance().performance("im", ih);
            resetData();
        }

        public static void resetData() {
            aTk = 0;
            aTl = 0;
            aTm = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aTn;
        public static long aTo;
        public static long aTp;
        public static long aTq;
        public static int aTr;
        public static int aTs;
        public static long aTt;

        public static void Km() {
            com.baidu.adp.lib.stats.a ih = l.ih();
            ih.append(AuthActivity.ACTION_KEY, "imcost");
            ih.append("dect", String.valueOf(aTo));
            ih.append("dlsize", String.valueOf(aTp));
            ih.append("dbt", String.valueOf(aTq));
            ih.append("pnum", String.valueOf(aTr));
            ih.append("reqcost", String.valueOf(aTt));
            ih.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(aTs));
            ih.append("totalNum", String.valueOf(aTn));
            BdStatisticsManager.getInstance().performance("im", ih);
            Kr();
        }

        public static void Kr() {
            aTn = 0;
            aTo = 0L;
            aTp = 0L;
            aTq = 0L;
            aTr = 0;
            aTs = 0;
        }
    }
}
