package com.baidu.tieba.b.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0052a {
        double x;
        double y;

        public C0052a() {
        }

        public C0052a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static C0052a a(C0052a c0052a, C0052a c0052a2, C0052a c0052a3, C0052a c0052a4, double d) {
        if (d < 0.0d || d > 1.0d || c0052a == null || c0052a2 == null || c0052a3 == null || c0052a4 == null) {
            return null;
        }
        C0052a c0052a5 = new C0052a();
        c0052a5.x = a(c0052a.x, c0052a2.x, c0052a3.x, c0052a4.x, d);
        c0052a5.y = a(c0052a.y, c0052a2.y, c0052a3.y, c0052a4.y, d);
        return c0052a5;
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
        C0052a a = a(new C0052a(0.0d, 0.0d), new C0052a(0.0d, f2), new C0052a(f - f2, f), new C0052a(f, f), ((i % f) + 1.0f) / f);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }

    public static double d(double d) {
        C0052a a = a(new C0052a(0.0d, 0.0d), new C0052a(0.0d, 0.3d), new C0052a(0.2d, 1.0d), new C0052a(1.0d, 1.0d), d);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }
}
