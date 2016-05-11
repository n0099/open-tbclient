package com.baidu.tieba.a.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0050a {
        double x;
        double y;

        public C0050a() {
        }

        public C0050a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static C0050a a(C0050a c0050a, C0050a c0050a2, C0050a c0050a3, C0050a c0050a4, double d) {
        if (d < 0.0d || d > 1.0d || c0050a == null || c0050a2 == null || c0050a3 == null || c0050a4 == null) {
            return null;
        }
        C0050a c0050a5 = new C0050a();
        c0050a5.x = a(c0050a.x, c0050a2.x, c0050a3.x, c0050a4.x, d);
        c0050a5.y = a(c0050a.y, c0050a2.y, c0050a3.y, c0050a4.y, d);
        return c0050a5;
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
        C0050a a = a(new C0050a(0.0d, 0.0d), new C0050a(0.0d, f2), new C0050a(f - f2, f), new C0050a(f, f), ((i % f) + 1.0f) / f);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }

    public static double c(double d) {
        C0050a a = a(new C0050a(0.0d, 0.0d), new C0050a(0.0d, 0.3d), new C0050a(0.2d, 1.0d), new C0050a(1.0d, 1.0d), d);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }
}
