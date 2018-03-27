package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class m extends o {
    public static int bAK = 100;
    public static int bAL = 10;

    public static void Ou() {
        if (p.Ow().Ox()) {
            if (b.bAP > bAL) {
                b.Oo();
            }
            if (a.bAM > bAL) {
                a.Oo();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.bAM++;
        if (z2) {
            a.bAN++;
        } else if (z3) {
            a.bAO++;
        }
        if (a.bAM > bAK) {
            a.Oo();
        }
    }

    public void c(i iVar) {
        if (p.Ow().Ox()) {
            if (b.bAP < bAK) {
                b.bAQ += iVar.aiR;
                b.bAR += iVar.bAk;
                b.bAS += iVar.bAl;
                b.bAT += iVar.bAm;
                b.bAV += iVar.auf;
                b.bAU += iVar.bAb;
                b.bAP++;
                return;
            }
            b.Oo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bAM;
        public static int bAN;
        public static int bAO;

        public static void Oo() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imbusy");
            nn.append("totalNum", String.valueOf(bAM));
            nn.append("tfailNum", String.valueOf(bAN));
            nn.append("qfailNum", String.valueOf(bAO));
            BdStatisticsManager.getInstance().performance("im", nn);
            resetData();
        }

        public static void resetData() {
            bAM = 0;
            bAN = 0;
            bAO = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bAP;
        public static long bAQ;
        public static long bAR;
        public static long bAS;
        public static int bAT;
        public static int bAU;
        public static long bAV;

        public static void Oo() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imcost");
            nn.append("dect", String.valueOf(bAQ));
            nn.append("dlsize", String.valueOf(bAR));
            nn.append("dbt", String.valueOf(bAS));
            nn.append("pnum", String.valueOf(bAT));
            nn.append("reqcost", String.valueOf(bAV));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(bAU));
            nn.append("totalNum", String.valueOf(bAP));
            BdStatisticsManager.getInstance().performance("im", nn);
            Ov();
        }

        public static void Ov() {
            bAP = 0;
            bAQ = 0L;
            bAR = 0L;
            bAS = 0L;
            bAT = 0;
            bAU = 0;
        }
    }
}
