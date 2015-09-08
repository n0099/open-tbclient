package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int ahp;
    private int ahq;
    private int ahr;

    public int wC() {
        if (this.ahp == 0) {
            return Integer.MAX_VALUE;
        }
        return this.ahp;
    }

    public void dK(String str) {
        this.ahp = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wD() {
        return this.ahq;
    }

    public void dL(String str) {
        this.ahq = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wE() {
        return this.ahr;
    }

    public void dM(String str) {
        this.ahr = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
