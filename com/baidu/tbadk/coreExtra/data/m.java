package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int ajV;
    private int ajW;
    private int ajX;

    public int xQ() {
        if (this.ajV == 0) {
            return Integer.MAX_VALUE;
        }
        return this.ajV;
    }

    public void ej(String str) {
        this.ajV = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int xR() {
        return this.ajW;
    }

    public void ek(String str) {
        this.ajW = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int xS() {
        return this.ajX;
    }

    public void el(String str) {
        this.ajX = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
