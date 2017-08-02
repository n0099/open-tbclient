package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int aqU;
    private int aqV;
    private int aqW;

    public int yj() {
        if (this.aqU == 0) {
            return Integer.MAX_VALUE;
        }
        return this.aqU;
    }

    public void eA(String str) {
        this.aqU = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yk() {
        return this.aqV;
    }

    public void eB(String str) {
        this.aqV = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yl() {
        return this.aqW;
    }

    public void eC(String str) {
        this.aqW = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
