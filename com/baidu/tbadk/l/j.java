package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class j extends l {
    public static int aUf = 100;
    public static int aUg = 10;

    public static void KD() {
        if (m.KF().KG()) {
            if (b.aUk > aUg) {
                b.Kz();
            }
            if (a.aUh > aUg) {
                a.Kz();
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        a.aUh++;
        if (z2) {
            a.aUi++;
        } else if (z3) {
            a.aUj++;
        }
        if (a.aUh > aUf) {
            a.Kz();
        }
    }

    public void c(f fVar) {
        if (m.KF().KG()) {
            if (b.aUk < aUf) {
                b.aUl += fVar.zp;
                b.aUm += fVar.aTD;
                b.aUn += fVar.aTE;
                b.aUo += fVar.aTF;
                b.aUq += fVar.KM;
                b.aUp += fVar.aTG;
                b.aUk++;
                return;
            }
            b.Kz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int aUh;
        public static int aUi;
        public static int aUj;

        public static void Kz() {
            com.baidu.adp.lib.stats.a ii = l.ii();
            ii.append(AuthActivity.ACTION_KEY, "imbusy");
            ii.append("totalNum", String.valueOf(aUh));
            ii.append("tfailNum", String.valueOf(aUi));
            ii.append("qfailNum", String.valueOf(aUj));
            BdStatisticsManager.getInstance().performance("im", ii);
            resetData();
        }

        public static void resetData() {
            aUh = 0;
            aUi = 0;
            aUj = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int aUk;
        public static long aUl;
        public static long aUm;
        public static long aUn;
        public static int aUo;
        public static int aUp;
        public static long aUq;

        public static void Kz() {
            com.baidu.adp.lib.stats.a ii = l.ii();
            ii.append(AuthActivity.ACTION_KEY, "imcost");
            ii.append("dect", String.valueOf(aUl));
            ii.append("dlsize", String.valueOf(aUm));
            ii.append("dbt", String.valueOf(aUn));
            ii.append("pnum", String.valueOf(aUo));
            ii.append("reqcost", String.valueOf(aUq));
            ii.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(aUp));
            ii.append("totalNum", String.valueOf(aUk));
            BdStatisticsManager.getInstance().performance("im", ii);
            KE();
        }

        public static void KE() {
            aUk = 0;
            aUl = 0L;
            aUm = 0L;
            aUn = 0L;
            aUo = 0;
            aUp = 0;
        }
    }
}
