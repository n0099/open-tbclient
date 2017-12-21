package com.baidu.tieba.b.c;
/* loaded from: classes.dex */
public class a {

    /* renamed from: com.baidu.tieba.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089a {
        double x;
        double y;

        public C0089a() {
        }

        public C0089a(double d, double d2) {
            this.x = d;
            this.y = d2;
        }
    }

    public static C0089a a(C0089a c0089a, C0089a c0089a2, C0089a c0089a3, C0089a c0089a4, double d) {
        if (d < 0.0d || d > 1.0d || c0089a == null || c0089a2 == null || c0089a3 == null || c0089a4 == null) {
            return null;
        }
        C0089a c0089a5 = new C0089a();
        c0089a5.x = a(c0089a.x, c0089a2.x, c0089a3.x, c0089a4.x, d);
        c0089a5.y = a(c0089a.y, c0089a2.y, c0089a3.y, c0089a4.y, d);
        return c0089a5;
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
        C0089a a = a(new C0089a(0.0d, 0.0d), new C0089a(0.0d, f2), new C0089a(f - f2, f), new C0089a(f, f), ((i % f) + 1.0f) / f);
        if (a == null) {
            return 0.0d;
        }
        return a.y;
    }
}
