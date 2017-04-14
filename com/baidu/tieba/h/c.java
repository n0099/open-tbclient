package com.baidu.tieba.h;
/* loaded from: classes.dex */
public class c {
    private static volatile c fsH = null;
    private b fsI;

    private c() {
        this.fsI = null;
        this.fsI = b.fsG;
    }

    public static c bge() {
        if (fsH == null) {
            synchronized (c.class) {
                if (fsH == null) {
                    fsH = new c();
                }
            }
        }
        return fsH;
    }

    public b bgf() {
        return this.fsI;
    }
}
