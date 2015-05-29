package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends ag {
    public static int aqK = 100;
    public static int aqL = 10;

    public static void Dz() {
        if (ah.DB().DC()) {
            if (ad.aqP > aqL) {
                ad.Do();
            }
            if (ac.aqM > aqL) {
                ac.Do();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        ac.aqM++;
        if (z2) {
            ac.aqN++;
        } else if (z3) {
            ac.aqO++;
        }
        if (ac.aqM > aqK) {
            ac.Do();
        }
    }

    public void c(r rVar) {
        if (ah.DB().DC()) {
            if (ad.aqP < aqK) {
                ad.aqQ += rVar.uK;
                ad.aqR += rVar.aqj;
                ad.aqS += rVar.aqk;
                ad.aqT += rVar.aql;
                ad.aqV += rVar.Gp;
                ad.aqU += rVar.aqa;
                ad.aqP++;
                return;
            }
            ad.Do();
        }
    }
}
