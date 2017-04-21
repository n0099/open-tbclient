package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cxZ = false;
    private int cya = -1;
    private int cyb = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cxZ = true;
        if (this.cya != -1) {
            wVar.ap(this.cya, this.cyb);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cya = i;
        this.cyb = i2;
        if (this.cxZ) {
            wVar.ap(this.cya, this.cyb);
        }
    }
}
