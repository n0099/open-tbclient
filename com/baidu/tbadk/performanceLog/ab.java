package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class ab extends ag {
    public static int apA = 100;
    public static int apB = 10;

    public static void CI() {
        if (ah.CK().CL()) {
            if (ad.apF > apB) {
                ad.Cx();
            }
            if (ac.apC > apB) {
                ac.Cx();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        ac.apC++;
        if (z2) {
            ac.apD++;
        } else if (z3) {
            ac.apE++;
        }
        if (ac.apC > apA) {
            ac.Cx();
        }
    }

    public void c(r rVar) {
        if (ah.CK().CL()) {
            if (ad.apF < apA) {
                ad.apG += rVar.vy;
                ad.apH += rVar.aoW;
                ad.apI += rVar.aoX;
                ad.apJ += rVar.aoY;
                ad.apL += rVar.Gx;
                ad.apK += rVar.aoN;
                ad.apF++;
                return;
            }
            ad.Cx();
        }
    }
}
