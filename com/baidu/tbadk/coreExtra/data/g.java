package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class g {
    private int aaV;
    private int aaW;
    private int aaX;

    public int uF() {
        if (this.aaV == 0) {
            return Integer.MAX_VALUE;
        }
        if (this.aaV >= 150) {
            return this.aaV;
        }
        return 150;
    }

    public void dk(String str) {
        this.aaV = com.baidu.adp.lib.g.c.toInt(str, 0);
    }

    public int uG() {
        if (this.aaW == 0) {
            return 200;
        }
        return this.aaW;
    }

    public void dl(String str) {
        this.aaW = com.baidu.adp.lib.g.c.toInt(str, 0);
    }

    public int uH() {
        if (this.aaX == 0) {
            return 90;
        }
        return this.aaX;
    }

    public void dm(String str) {
        this.aaX = com.baidu.adp.lib.g.c.toInt(str, 0);
    }
}
