package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int bhE;
    private int bhF;
    private int bhG;

    public int FQ() {
        if (this.bhE == 0) {
            return Integer.MAX_VALUE;
        }
        return this.bhE;
    }

    public void fj(String str) {
        this.bhE = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FR() {
        return this.bhF;
    }

    public void fk(String str) {
        this.bhF = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FS() {
        return this.bhG;
    }

    public void fl(String str) {
        this.bhG = com.baidu.adp.lib.g.b.h(str, 0);
    }
}
