package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int apo;
    private int apq;
    private int apr;

    public int yA() {
        if (this.apo == 0) {
            return Integer.MAX_VALUE;
        }
        return this.apo;
    }

    public void eg(String str) {
        this.apo = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yB() {
        return this.apq;
    }

    public void eh(String str) {
        this.apq = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yC() {
        return this.apr;
    }

    public void ei(String str) {
        this.apr = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
