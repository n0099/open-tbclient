package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class x extends ab {
    public static int agZ = 100;
    public static int aha = 10;

    public static void zw() {
        if (ac.zy().zz()) {
            if (z.ahe > aha) {
                z.zp();
            }
            if (y.ahb > aha) {
                y.zp();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        y.ahb++;
        if (z2) {
            y.ahc++;
        } else if (z3) {
            y.ahd++;
        }
        if (y.ahb > agZ) {
            y.zp();
        }
    }

    public void c(r rVar) {
        if (ac.zy().zz()) {
            if (z.ahe < agZ) {
                z.ahf += rVar.ki;
                z.ahg += rVar.agE;
                z.ahh += rVar.agF;
                z.ahi += rVar.agG;
                z.ahk += rVar.vD;
                z.ahj += rVar.agv;
                z.ahe++;
                return;
            }
            z.zp();
        }
    }
}
