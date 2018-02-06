package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class m extends o {
    public static int bAU = 100;
    public static int bAV = 10;

    public static void Ou() {
        if (p.Ow().Ox()) {
            if (b.bAZ > bAV) {
                b.Oo();
            }
            if (a.bAW > bAV) {
                a.Oo();
            }
        }
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        a.bAW++;
        if (z2) {
            a.bAX++;
        } else if (z3) {
            a.bAY++;
        }
        if (a.bAW > bAU) {
            a.Oo();
        }
    }

    public void c(i iVar) {
        if (p.Ow().Ox()) {
            if (b.bAZ < bAU) {
                b.bBa += iVar.aiX;
                b.bBb += iVar.bAu;
                b.bBc += iVar.bAv;
                b.bBd += iVar.bAw;
                b.bBf += iVar.aun;
                b.bBe += iVar.bAl;
                b.bAZ++;
                return;
            }
            b.Oo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static int bAW;
        public static int bAX;
        public static int bAY;

        public static void Oo() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imbusy");
            nn.append("totalNum", String.valueOf(bAW));
            nn.append("tfailNum", String.valueOf(bAX));
            nn.append("qfailNum", String.valueOf(bAY));
            BdStatisticsManager.getInstance().performance("im", nn);
            resetData();
        }

        public static void resetData() {
            bAW = 0;
            bAX = 0;
            bAY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public static int bAZ;
        public static long bBa;
        public static long bBb;
        public static long bBc;
        public static int bBd;
        public static int bBe;
        public static long bBf;

        public static void Oo() {
            com.baidu.adp.lib.stats.a nn = o.nn();
            nn.append(AuthActivity.ACTION_KEY, "imcost");
            nn.append("dect", String.valueOf(bBa));
            nn.append("dlsize", String.valueOf(bBb));
            nn.append("dbt", String.valueOf(bBc));
            nn.append("pnum", String.valueOf(bBd));
            nn.append("reqcost", String.valueOf(bBf));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(bBe));
            nn.append("totalNum", String.valueOf(bAZ));
            BdStatisticsManager.getInstance().performance("im", nn);
            Ov();
        }

        public static void Ov() {
            bAZ = 0;
            bBa = 0L;
            bBb = 0L;
            bBc = 0L;
            bBd = 0;
            bBe = 0;
        }
    }
}
