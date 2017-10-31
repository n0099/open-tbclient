package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int ard;
    private int are;
    private int arf;

    public int xT() {
        if (this.ard == 0) {
            return Integer.MAX_VALUE;
        }
        return this.ard;
    }

    public void eE(String str) {
        this.ard = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xU() {
        return this.are;
    }

    public void eF(String str) {
        this.are = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xV() {
        return this.arf;
    }

    public void eG(String str) {
        this.arf = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
