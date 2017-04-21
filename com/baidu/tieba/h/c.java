package com.baidu.tieba.h;
/* loaded from: classes.dex */
public class c {
    private static volatile c fuY = null;
    private b fuZ;

    private c() {
        this.fuZ = null;
        this.fuZ = b.fuX;
    }

    public static c bhg() {
        if (fuY == null) {
            synchronized (c.class) {
                if (fuY == null) {
                    fuY = new c();
                }
            }
        }
        return fuY;
    }

    public b bhh() {
        return this.fuZ;
    }
}
