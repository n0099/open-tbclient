package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int apu;
    private int apv;
    private int apw;

    public int xO() {
        if (this.apu == 0) {
            return Integer.MAX_VALUE;
        }
        return this.apu;
    }

    public void ef(String str) {
        this.apu = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xP() {
        return this.apv;
    }

    public void eg(String str) {
        this.apv = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xQ() {
        return this.apw;
    }

    public void eh(String str) {
        this.apw = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
