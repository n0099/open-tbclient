package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cDY = false;
    private int cDZ = -1;
    private int cEa = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cDY = true;
        if (this.cDZ != -1) {
            wVar.as(this.cDZ, this.cEa);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cDZ = i;
        this.cEa = i2;
        if (this.cDY) {
            wVar.as(this.cDZ, this.cEa);
        }
    }
}
