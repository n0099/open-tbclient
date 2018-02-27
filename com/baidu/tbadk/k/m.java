package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class m extends o {
    public static int bAH = 100;
    public static int bAI = 10;

    public static void Ot() {
        if (p.Ov().Ow()) {
            if (b.bAM > bAI) {
                b.On();
            }
            if (a.bAJ > bAI) {
                a.On();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.bAJ++;
        if (z2) {
            a.bAK++;
        } else if (z3) {
            a.bAL++;
        }
        if (a.bAJ > bAH) {
            a.On();
        }
    }

    public void c(i iVar) {
        if (p.Ov().Ow()) {
            if (b.bAM < bAH) {
                b.bAN += iVar.aiR;
                b.bAO += iVar.bAh;
                b.bAP += iVar.bAi;
                b.bAQ += iVar.bAj;
                b.bAS += iVar.aue;
                b.bAR += iVar.bzY;
                b.bAM++;
                return;
            }
            b.On();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bAJ;
        public static int bAK;
        public static int bAL;

        public static void On() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imbusy");
            nn.append("totalNum", String.valueOf(bAJ));
            nn.append("tfailNum", String.valueOf(bAK));
            nn.append("qfailNum", String.valueOf(bAL));
            BdStatisticsManager.getInstance().performance("im", nn);
            resetData();
        }

        public static void resetData() {
            bAJ = 0;
            bAK = 0;
            bAL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bAM;
        public static long bAN;
        public static long bAO;
        public static long bAP;
        public static int bAQ;
        public static int bAR;
        public static long bAS;

        public static void On() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imcost");
            nn.append("dect", String.valueOf(bAN));
            nn.append("dlsize", String.valueOf(bAO));
            nn.append("dbt", String.valueOf(bAP));
            nn.append("pnum", String.valueOf(bAQ));
            nn.append("reqcost", String.valueOf(bAS));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(bAR));
            nn.append("totalNum", String.valueOf(bAM));
            BdStatisticsManager.getInstance().performance("im", nn);
            Ou();
        }

        public static void Ou() {
            bAM = 0;
            bAN = 0L;
            bAO = 0L;
            bAP = 0L;
            bAQ = 0;
            bAR = 0;
        }
    }
}
