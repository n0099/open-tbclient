package com.baidu.tieba.animation3d.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.animation3d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0135a {
        double x;
        double y;

        public C0135a() {
        }

        public C0135a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static C0135a a(C0135a c0135a, C0135a c0135a2, C0135a c0135a3, C0135a c0135a4, double d) {
        if (d < 0.0d || d > 1.0d || c0135a == null || c0135a2 == null || c0135a3 == null || c0135a4 == null) {
            return null;
        }
        C0135a c0135a5 = new C0135a();
        c0135a5.x = a(c0135a.x, c0135a2.x, c0135a3.x, c0135a4.x, d);
        c0135a5.y = a(c0135a.y, c0135a2.y, c0135a3.y, c0135a4.y, d);
        return c0135a5;
    }

    public static double a(double d, double d2, double d3, double d4, double d5) {
        if (d5 < 0.0d || d5 > 1.0d) {
            return 0.0d;
        }
        return (Math.pow(1.0d - d5, 3.0d) * d) + (3.0d * d5 * Math.pow(1.0d - d5, 2.0d) * d2) + (3.0d * (1.0d - d5) * Math.pow(d5, 2.0d) * d3) + (Math.pow(d5, 3.0d) * d4);
    }

    public static double b(int i, float f, float f2, float f3) {
        if (i <= f) {
            return a(i, f, f2) / f3;
        }
        if (i > f && i <= 2.0f * f) {
            return (-a((int) ((2.0f * f) - i), f, f2)) / f3;
        }
        return 0.0d;
    }

    public static double a(int i, float f, float f2) {
        C0135a a = a(new C0135a(0.0d, 0.0d), new C0135a(0.0d, f2), new C0135a(f - f2, f), new C0135a(f, f), ((i % f) + 1.0f) / f);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }
}
