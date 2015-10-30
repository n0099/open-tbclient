package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int agm;
    private int agn;
    private int ago;

    public int wj() {
        if (this.agm == 0) {
            return Integer.MAX_VALUE;
        }
        return this.agm;
    }

    public void dN(String str) {
        this.agm = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wk() {
        return this.agn;
    }

    public void dO(String str) {
        this.agn = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wl() {
        return this.ago;
    }

    public void dP(String str) {
        this.ago = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
