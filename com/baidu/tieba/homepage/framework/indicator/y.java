package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int coE = -1;
    private boolean coF = false;
    private boolean coG = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.coF = true;
        if (this.coE != -1 && this.coG) {
            yVar.jn(this.coE);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.coE = i;
        if (this.coF && this.coG) {
            yVar.jn(this.coE);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.coG = true;
        if (this.coE != -1 && this.coF) {
            yVar.jn(this.coE);
        }
    }
}
