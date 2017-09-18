package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int arQ;
    private int arR;
    private int arS;

    public int yu() {
        if (this.arQ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.arQ;
    }

    public void eE(String str) {
        this.arQ = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yv() {
        return this.arR;
    }

    public void eF(String str) {
        this.arR = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yw() {
        return this.arS;
    }

    public void eG(String str) {
        this.arS = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
