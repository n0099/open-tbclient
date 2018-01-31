package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int bfX;
    private int bfY;
    private int bfZ;

    public int Fv() {
        if (this.bfX == 0) {
            return Integer.MAX_VALUE;
        }
        return this.bfX;
    }

    public void eX(String str) {
        this.bfX = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int Fw() {
        return this.bfY;
    }

    public void eY(String str) {
        this.bfY = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int Fx() {
        return this.bfZ;
    }

    public void eZ(String str) {
        this.bfZ = com.baidu.adp.lib.g.b.h(str, 0);
    }
}
