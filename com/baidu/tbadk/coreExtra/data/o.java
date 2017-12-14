package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int arG;
    private int arH;
    private int arI;

    public int yd() {
        if (this.arG == 0) {
            return Integer.MAX_VALUE;
        }
        return this.arG;
    }

    public void eJ(String str) {
        this.arG = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int ye() {
        return this.arH;
    }

    public void eK(String str) {
        this.arH = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yf() {
        return this.arI;
    }

    public void eL(String str) {
        this.arI = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
