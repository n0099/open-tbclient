package com.baidu.tieba.a.c;
/* loaded from: classes.dex */
public class b {
    public static double a(int i, double d) {
        double sin = (60.0d * Math.sin(((30.0d * i) * 3.141592653589793d) / 180.0d)) / Math.exp(i * 0.2d);
        if (sin < 0.0d) {
            return -Math.sqrt(-sin);
        }
        return Math.sqrt(sin);
    }
}
