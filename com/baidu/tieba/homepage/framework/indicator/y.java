package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cJj = -1;
    private boolean cJk = false;
    private boolean cJl = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cJk = true;
        if (this.cJj != -1 && this.cJl) {
            yVar.kc(this.cJj);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cJj = i;
        if (this.cJk && this.cJl) {
            yVar.kc(this.cJj);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cJl = true;
        if (this.cJj != -1 && this.cJk) {
            yVar.kc(this.cJj);
        }
    }
}
