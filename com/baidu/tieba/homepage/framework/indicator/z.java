package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cDu = false;
    private int cDv = -1;
    private int cDw = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cDu = true;
        if (this.cDv != -1) {
            wVar.ar(this.cDv, this.cDw);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cDv = i;
        this.cDw = i2;
        if (this.cDu) {
            wVar.ar(this.cDv, this.cDw);
        }
    }
}
