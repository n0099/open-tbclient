package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int arJ;
    private int arK;
    private int arL;

    public int yd() {
        if (this.arJ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.arJ;
    }

    public void eJ(String str) {
        this.arJ = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int ye() {
        return this.arK;
    }

    public void eK(String str) {
        this.arK = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yf() {
        return this.arL;
    }

    public void eL(String str) {
        this.arL = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
