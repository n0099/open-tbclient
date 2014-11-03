package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class q extends u {
    public static int Zm = 100;
    public static int Zn = 10;

    public static void uN() {
        if (v.uP().uQ()) {
            if (s.Zr > Zn) {
                s.uG();
            }
            if (r.Zo > Zn) {
                r.uG();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        r.Zo++;
        if (z2) {
            r.Zp++;
        } else if (z3) {
            r.Zq++;
        }
        if (r.Zo > Zm) {
            r.uG();
        }
    }

    public void c(k kVar) {
        if (v.uP().uQ()) {
            if (s.Zr < Zm) {
                s.Zs += kVar.kd;
                s.Zt += kVar.YR;
                s.Zu += kVar.YS;
                s.Zv += kVar.YT;
                s.Zx += kVar.tm;
                s.Zw += kVar.YK;
                s.Zr++;
                return;
            }
            s.uG();
        }
    }
}
