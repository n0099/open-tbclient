package com.baidu.tieba.i;
/* loaded from: classes.dex */
public class c {
    private static volatile c frb = null;
    private b frc;

    private c() {
        this.frc = null;
        this.frc = b.fra;
    }

    public static c beJ() {
        if (frb == null) {
            synchronized (c.class) {
                if (frb == null) {
                    frb = new c();
                }
            }
        }
        return frb;
    }

    public b beK() {
        return this.frc;
    }
}
