package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class n {
    private int arj;
    private int ark;
    private int arl;

    public int yb() {
        if (this.arj == 0) {
            return Integer.MAX_VALUE;
        }
        return this.arj;
    }

    public void eE(String str) {
        this.arj = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yc() {
        return this.ark;
    }

    public void eF(String str) {
        this.ark = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yd() {
        return this.arl;
    }

    public void eG(String str) {
        this.arl = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
