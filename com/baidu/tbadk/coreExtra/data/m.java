package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int aqY;
    private int aqZ;
    private int ara;

    public int xT() {
        if (this.aqY == 0) {
            return Integer.MAX_VALUE;
        }
        return this.aqY;
    }

    public void ey(String str) {
        this.aqY = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xU() {
        return this.aqZ;
    }

    public void ez(String str) {
        this.aqZ = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xV() {
        return this.ara;
    }

    public void eA(String str) {
        this.ara = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
