package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cxW = -1;
    private boolean cxX = false;
    private boolean cxY = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cxX = true;
        if (this.cxW != -1 && this.cxY) {
            yVar.jM(this.cxW);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cxW = i;
        if (this.cxX && this.cxY) {
            yVar.jM(this.cxW);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cxY = true;
        if (this.cxW != -1 && this.cxX) {
            yVar.jM(this.cxW);
        }
    }
}
