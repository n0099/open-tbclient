package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class z {
    private boolean cJm = false;
    private int cJn = -1;
    private int cJo = -1;

    public void a(com.baidu.tieba.homepage.framework.w wVar) {
        this.cJm = true;
        if (this.cJn != -1) {
            wVar.at(this.cJn, this.cJo);
        }
    }

    public void a(int i, int i2, com.baidu.tieba.homepage.framework.w wVar) {
        this.cJn = i;
        this.cJo = i2;
        if (this.cJm) {
            wVar.at(this.cJn, this.cJo);
        }
    }
}
