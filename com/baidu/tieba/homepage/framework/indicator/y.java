package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cDr = -1;
    private boolean cDs = false;
    private boolean cDt = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cDs = true;
        if (this.cDr != -1 && this.cDt) {
            yVar.jP(this.cDr);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cDr = i;
        if (this.cDs && this.cDt) {
            yVar.jP(this.cDr);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cDt = true;
        if (this.cDr != -1 && this.cDs) {
            yVar.jP(this.cDr);
        }
    }
}
