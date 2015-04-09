package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends ag {
    public static int apI = 100;
    public static int apJ = 10;

    public static void CO() {
        if (ah.CQ().CR()) {
            if (ad.apN > apJ) {
                ad.CD();
            }
            if (ac.apK > apJ) {
                ac.CD();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        ac.apK++;
        if (z2) {
            ac.apL++;
        } else if (z3) {
            ac.apM++;
        }
        if (ac.apK > apI) {
            ac.CD();
        }
    }

    public void c(r rVar) {
        if (ah.CQ().CR()) {
            if (ad.apN < apI) {
                ad.apO += rVar.vy;
                ad.apP += rVar.ape;
                ad.apQ += rVar.apf;
                ad.apR += rVar.apg;
                ad.apT += rVar.Gz;
                ad.apS += rVar.aoV;
                ad.apN++;
                return;
            }
            ad.CD();
        }
    }
}
