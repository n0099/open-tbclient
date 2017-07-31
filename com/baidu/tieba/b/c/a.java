package com.baidu.tieba.b.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072a {
        double x;
        double y;

        public C0072a() {
        }

        public C0072a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static C0072a a(C0072a c0072a, C0072a c0072a2, C0072a c0072a3, C0072a c0072a4, double d) {
        if (d < 0.0d || d > 1.0d || c0072a == null || c0072a2 == null || c0072a3 == null || c0072a4 == null) {
            return null;
        }
        C0072a c0072a5 = new C0072a();
        c0072a5.x = a(c0072a.x, c0072a2.x, c0072a3.x, c0072a4.x, d);
        c0072a5.y = a(c0072a.y, c0072a2.y, c0072a3.y, c0072a4.y, d);
        return c0072a5;
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
        C0072a a = a(new C0072a(0.0d, 0.0d), new C0072a(0.0d, f2), new C0072a(f - f2, f), new C0072a(f, f), ((i % f) + 1.0f) / f);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }
}
