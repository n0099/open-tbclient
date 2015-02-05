package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class x extends ab {
    public static int agW = 100;
    public static int agX = 10;

    public static void zq() {
        if (ac.zs().zt()) {
            if (z.ahb > agX) {
                z.zj();
            }
            if (y.agY > agX) {
                y.zj();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        y.agY++;
        if (z2) {
            y.agZ++;
        } else if (z3) {
            y.aha++;
        }
        if (y.agY > agW) {
            y.zj();
        }
    }

    public void c(r rVar) {
        if (ac.zs().zt()) {
            if (z.ahb < agW) {
                z.ahc += rVar.ki;
                z.ahd += rVar.agB;
                z.ahe += rVar.agC;
                z.ahf += rVar.agD;
                z.ahh += rVar.vA;
                z.ahg += rVar.ags;
                z.ahb++;
                return;
            }
            z.zj();
        }
    }
}
