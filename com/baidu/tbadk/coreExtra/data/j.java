package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class j {
    private int aho;
    private int ahp;
    private int ahq;

    public int wD() {
        if (this.aho == 0) {
            return Integer.MAX_VALUE;
        }
        return this.aho;
    }

    public void ed(String str) {
        this.aho = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wE() {
        return this.ahp;
    }

    public void ee(String str) {
        this.ahp = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int wF() {
        return this.ahq;
    }

    public void ef(String str) {
        this.ahq = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
