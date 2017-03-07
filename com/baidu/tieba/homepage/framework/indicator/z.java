package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cxi = false;
    private int cxj = -1;
    private int cxk = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cxi = true;
        if (this.cxj != -1) {
            wVar.ar(this.cxj, this.cxk);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cxj = i;
        this.cxk = i2;
        if (this.cxi) {
            wVar.ar(this.cxj, this.cxk);
        }
    }
}
