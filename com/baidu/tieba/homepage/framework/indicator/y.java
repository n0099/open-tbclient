package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cvG = -1;
    private boolean cvH = false;
    private boolean cvI = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cvH = true;
        if (this.cvG != -1 && this.cvI) {
            yVar.ka(this.cvG);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cvG = i;
        if (this.cvH && this.cvI) {
            yVar.ka(this.cvG);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cvI = true;
        if (this.cvG != -1 && this.cvH) {
            yVar.ka(this.cvG);
        }
    }
}
