package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int agl;
    private int agm;
    private int agn;

    public int wm() {
        if (this.agl == 0) {
            return Integer.MAX_VALUE;
        }
        return this.agl;
    }

    public void dN(String str) {
        this.agl = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wn() {
        return this.agm;
    }

    public void dO(String str) {
        this.agm = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wo() {
        return this.agn;
    }

    public void dP(String str) {
        this.agn = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
