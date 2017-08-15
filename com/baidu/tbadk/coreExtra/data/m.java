package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int asn;
    private int aso;
    private int asp;

    public int yr() {
        if (this.asn == 0) {
            return Integer.MAX_VALUE;
        }
        return this.asn;
    }

    public void eG(String str) {
        this.asn = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int ys() {
        return this.aso;
    }

    public void eH(String str) {
        this.aso = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yt() {
        return this.asp;
    }

    public void eI(String str) {
        this.asp = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
