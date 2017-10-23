package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int aqM;
    private int aqN;
    private int aqO;

    public int xM() {
        if (this.aqM == 0) {
            return Integer.MAX_VALUE;
        }
        return this.aqM;
    }

    public void ex(String str) {
        this.aqM = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xN() {
        return this.aqN;
    }

    public void ey(String str) {
        this.aqN = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int xO() {
        return this.aqO;
    }

    public void ez(String str) {
        this.aqO = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
