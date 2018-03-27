package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int bhH;
    private int bhI;
    private int bhJ;

    public int FR() {
        if (this.bhH == 0) {
            return Integer.MAX_VALUE;
        }
        return this.bhH;
    }

    public void fj(String str) {
        this.bhH = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FS() {
        return this.bhI;
    }

    public void fk(String str) {
        this.bhI = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FT() {
        return this.bhJ;
    }

    public void fl(String str) {
        this.bhJ = com.baidu.adp.lib.g.b.h(str, 0);
    }
}
