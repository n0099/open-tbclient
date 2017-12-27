package com.baidu.tbadk.coreExtra.data;
/* loaded from: classes.dex */
public class o {
    private int bfJ;
    private int bfK;
    private int bfL;

    public int FC() {
        if (this.bfJ == 0) {
            return Integer.MAX_VALUE;
        }
        return this.bfJ;
    }

    public void eQ(String str) {
        this.bfJ = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FD() {
        return this.bfK;
    }

    public void eR(String str) {
        this.bfK = com.baidu.adp.lib.g.b.h(str, 0);
    }

    public int FE() {
        return this.bfL;
    }

    public void eS(String str) {
        this.bfL = com.baidu.adp.lib.g.b.h(str, 0);
    }
}
