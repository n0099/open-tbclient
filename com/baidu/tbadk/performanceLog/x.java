package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class x extends ab {
    public static int agB = 100;
    public static int agC = 10;

    public static void zf() {
        if (ac.zh().zi()) {
            if (z.agG > agC) {
                z.yY();
            }
            if (y.agD > agC) {
                y.yY();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        y.agD++;
        if (z2) {
            y.agE++;
        } else if (z3) {
            y.agF++;
        }
        if (y.agD > agB) {
            y.yY();
        }
    }

    public void c(r rVar) {
        if (ac.zh().zi()) {
            if (z.agG < agB) {
                z.agH += rVar.kf;
                z.agI += rVar.agg;
                z.agJ += rVar.agh;
                z.agK += rVar.agi;
                z.agM += rVar.vx;
                z.agL += rVar.afX;
                z.agG++;
                return;
            }
            z.yY();
        }
    }
}
