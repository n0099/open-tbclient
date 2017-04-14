package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cvF = -1;
    private boolean cvG = false;
    private boolean cvH = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cvG = true;
        if (this.cvF != -1 && this.cvH) {
            yVar.jG(this.cvF);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cvF = i;
        if (this.cvG && this.cvH) {
            yVar.jG(this.cvF);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cvH = true;
        if (this.cvF != -1 && this.cvG) {
            yVar.jG(this.cvF);
        }
    }
}
