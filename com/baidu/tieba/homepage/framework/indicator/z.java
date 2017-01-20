package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cvJ = false;
    private int cvK = -1;
    private int cvL = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cvJ = true;
        if (this.cvK != -1) {
            wVar.ao(this.cvK, this.cvL);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cvK = i;
        this.cvL = i2;
        if (this.cvJ) {
            wVar.ao(this.cvK, this.cvL);
        }
    }
}
