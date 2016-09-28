package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cDV = -1;
    private boolean cDW = false;
    private boolean cDX = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cDW = true;
        if (this.cDV != -1 && this.cDX) {
            yVar.jV(this.cDV);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cDV = i;
        if (this.cDW && this.cDX) {
            yVar.jV(this.cDV);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cDX = true;
        if (this.cDV != -1 && this.cDW) {
            yVar.jV(this.cDV);
        }
    }
}
