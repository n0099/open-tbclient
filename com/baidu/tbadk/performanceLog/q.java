package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class q extends u {
    public static int Zi = 100;
    public static int Zj = 10;

    public static void uL() {
        if (v.uN().uO()) {
            if (s.Zn > Zj) {
                s.uE();
            }
            if (r.Zk > Zj) {
                r.uE();
            }
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        r.Zk++;
        if (z2) {
            r.Zl++;
        } else if (z3) {
            r.Zm++;
        }
        if (r.Zk > Zi) {
            r.uE();
        }
    }

    public void c(k kVar) {
        if (v.uN().uO()) {
            if (s.Zn < Zi) {
                s.Zo += kVar.kd;
                s.Zp += kVar.YN;
                s.Zq += kVar.YO;
                s.Zr += kVar.YP;
                s.Zt += kVar.tm;
                s.Zs += kVar.YG;
                s.Zn++;
                return;
            }
            s.uE();
        }
    }
}
