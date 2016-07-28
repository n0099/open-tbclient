package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean csm = false;
    private int csn = -1;
    private int cso = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.csm = true;
        if (this.csn != -1) {
            wVar.am(this.csn, this.cso);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.csn = i;
        this.cso = i2;
        if (this.csm) {
            wVar.am(this.csn, this.cso);
        }
    }
}
