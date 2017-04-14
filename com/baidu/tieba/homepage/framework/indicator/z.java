package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cvI = false;
    private int cvJ = -1;
    private int cvK = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cvI = true;
        if (this.cvJ != -1) {
            wVar.ap(this.cvJ, this.cvK);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cvJ = i;
        this.cvK = i2;
        if (this.cvI) {
            wVar.ap(this.cvJ, this.cvK);
        }
    }
}
