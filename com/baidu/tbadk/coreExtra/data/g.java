package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int ags;
    private int agt;
    private int agu;

    public int wo() {
        if (this.ags == 0) {
            return Integer.MAX_VALUE;
        }
        return this.ags;
    }

    public void dN(String str) {
        this.ags = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wp() {
        return this.agt;
    }

    public void dO(String str) {
        this.agt = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int wq() {
        return this.agu;
    }

    public void dP(String str) {
        this.agu = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
