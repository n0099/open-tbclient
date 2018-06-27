package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class j extends l {
    public static int aUe = 100;
    public static int aUf = 10;

    public static void KI() {
        if (m.KK().KL()) {
            if (b.aUj > aUf) {
                b.KE();
            }
            if (a.aUg > aUf) {
                a.KE();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aUg++;
        if (z2) {
            a.aUh++;
        } else if (z3) {
            a.aUi++;
        }
        if (a.aUg > aUe) {
            a.KE();
        }
    }

    public void c(f fVar) {
        if (m.KK().KL()) {
            if (b.aUj < aUe) {
                b.aUk += fVar.zu;
                b.aUl += fVar.aTC;
                b.aUm += fVar.aTD;
                b.aUn += fVar.aTE;
                b.aUp += fVar.KQ;
                b.aUo += fVar.aTF;
                b.aUj++;
                return;
            }
            b.KE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aUg;
        public static int aUh;
        public static int aUi;

        public static void KE() {
            com.baidu.adp.lib.stats.a ih = l.ih();
            ih.append(AuthActivity.ACTION_KEY, "imbusy");
            ih.append("totalNum", String.valueOf(aUg));
            ih.append("tfailNum", String.valueOf(aUh));
            ih.append("qfailNum", String.valueOf(aUi));
            BdStatisticsManager.getInstance().performance("im", ih);
            resetData();
        }

        public static void resetData() {
            aUg = 0;
            aUh = 0;
            aUi = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aUj;
        public static long aUk;
        public static long aUl;
        public static long aUm;
        public static int aUn;
        public static int aUo;
        public static long aUp;

        public static void KE() {
            com.baidu.adp.lib.stats.a ih = l.ih();
            ih.append(AuthActivity.ACTION_KEY, "imcost");
            ih.append("dect", String.valueOf(aUk));
            ih.append("dlsize", String.valueOf(aUl));
            ih.append("dbt", String.valueOf(aUm));
            ih.append("pnum", String.valueOf(aUn));
            ih.append("reqcost", String.valueOf(aUp));
            ih.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(aUo));
            ih.append("totalNum", String.valueOf(aUj));
            BdStatisticsManager.getInstance().performance("im", ih);
            KJ();
        }

        public static void KJ() {
            aUj = 0;
            aUk = 0L;
            aUl = 0L;
            aUm = 0L;
            aUn = 0;
            aUo = 0;
        }
    }
}
