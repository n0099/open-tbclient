package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int asm;
    private int asn;
    private int aso;

    public int yr() {
        if (this.asm == 0) {
            return Integer.MAX_VALUE;
        }
        return this.asm;
    }

    public void eG(String str) {
        this.asm = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int ys() {
        return this.asn;
    }

    public void eH(String str) {
        this.asn = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yt() {
        return this.aso;
    }

    public void eI(String str) {
        this.aso = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
