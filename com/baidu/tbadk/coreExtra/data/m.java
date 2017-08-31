package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int arT;
    private int arU;
    private int arV;

    public int yu() {
        if (this.arT == 0) {
            return Integer.MAX_VALUE;
        }
        return this.arT;
    }

    public void eE(String str) {
        this.arT = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yv() {
        return this.arU;
    }

    public void eF(String str) {
        this.arU = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yw() {
        return this.arV;
    }

    public void eG(String str) {
        this.arV = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
