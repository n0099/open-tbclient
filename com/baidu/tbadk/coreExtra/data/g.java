package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int abZ;
    private int aca;
    private int acb;

    public int vp() {
        if (this.abZ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.abZ;
    }

    public void dB(String str) {
        this.abZ = com.baidu.adp.lib.g.c.toInt(str, 0);
    }

    public int vq() {
        return this.aca;
    }

    public void dC(String str) {
        this.aca = com.baidu.adp.lib.g.c.toInt(str, 0);
    }

    public int vr() {
        return this.acb;
    }

    public void dD(String str) {
        this.acb = com.baidu.adp.lib.g.c.toInt(str, 0);
    }
}
