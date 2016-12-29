package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean coH = false;
    private int coI = -1;
    private int coJ = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.coH = true;
        if (this.coI != -1) {
            wVar.ao(this.coI, this.coJ);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.coI = i;
        this.coJ = i2;
        if (this.coH) {
            wVar.ao(this.coI, this.coJ);
        }
    }
}
