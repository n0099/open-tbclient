package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int aoZ;
    private int apa;
    private int apb;

    public int yc() {
        if (this.aoZ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.aoZ;
    }

    public void ea(String str) {
        this.aoZ = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yd() {
        return this.apa;
    }

    public void eb(String str) {
        this.apa = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int ye() {
        return this.apb;
    }

    public void ec(String str) {
        this.apb = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
