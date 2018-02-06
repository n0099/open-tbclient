package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int bhQ;
    private int bhR;
    private int bhS;

    public int FR() {
        if (this.bhQ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.bhQ;
    }

    public void fj(String str) {
        this.bhQ = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FS() {
        return this.bhR;
    }

    public void fk(String str) {
        this.bhR = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FT() {
        return this.bhS;
    }

    public void fl(String str) {
        this.bhS = com.baidu.adp.lib.g.b.h(str, 0);
    }
}
