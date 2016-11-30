package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class m {
    private int akN;
    private int akO;
    private int akP;

    public int xW() {
        if (this.akN == 0) {
            return Integer.MAX_VALUE;
        }
        return this.akN;
    }

    public void el(String str) {
        this.akN = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int xX() {
        return this.akO;
    }

    public void em(String str) {
        this.akO = com.baidu.adp.lib.h.b.g(str, 0);
    }

    public int xY() {
        return this.akP;
    }

    public void en(String str) {
        this.akP = com.baidu.adp.lib.h.b.g(str, 0);
    }
}
