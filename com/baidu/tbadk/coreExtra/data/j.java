package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private int agA;
    private int agB;
    private int agC;

    public int wD() {
        if (this.agA == 0) {
            return Integer.MAX_VALUE;
        }
        return this.agA;
    }

    public void ee(String str) {
        this.agA = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wE() {
        return this.agB;
    }

    public void ef(String str) {
        this.agB = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wF() {
        return this.agC;
    }

    public void eg(String str) {
        this.agC = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
