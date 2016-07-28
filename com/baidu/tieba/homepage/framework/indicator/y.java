package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int csj = -1;
    private boolean csk = false;
    private boolean csl = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.csk = true;
        if (this.csj != -1 && this.csl) {
            yVar.jn(this.csj);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.csj = i;
        if (this.csk && this.csl) {
            yVar.jn(this.csj);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.csl = true;
        if (this.csj != -1 && this.csk) {
            yVar.jn(this.csj);
        }
    }
}
