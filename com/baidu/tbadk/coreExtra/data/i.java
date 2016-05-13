package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class i {
    private int afW;
    private int afX;
    private int afY;

    public int wA() {
        if (this.afW == 0) {
            return Integer.MAX_VALUE;
        }
        return this.afW;
    }

    public void ea(String str) {
        this.afW = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wB() {
        return this.afX;
    }

    public void eb(String str) {
        this.afX = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wC() {
        return this.afY;
    }

    public void ec(String str) {
        this.afY = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
