package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class i {
    private int ajU;
    private int ajV;
    private int ajW;

    public int yf() {
        if (this.ajU == 0) {
            return Integer.MAX_VALUE;
        }
        return this.ajU;
    }

    public void dX(String str) {
        this.ajU = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int yg() {
        return this.ajV;
    }

    public void dY(String str) {
        this.ajV = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int yh() {
        return this.ajW;
    }

    public void dZ(String str) {
        this.ajW = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
