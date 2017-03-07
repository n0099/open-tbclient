package com.baidu.tieba.homepage.framework.indicator;
/* loaded from: classes.dex */
public class y {
    private int cxf = -1;
    private boolean cxg = false;
    private boolean cxh = false;

    public void a(com.baidu.tieba.homepage.framework.y yVar) {
        this.cxg = true;
        if (this.cxf != -1 && this.cxh) {
            yVar.jF(this.cxf);
        }
    }

    public void a(int i, com.baidu.tieba.homepage.framework.y yVar) {
        this.cxf = i;
        if (this.cxg && this.cxh) {
            yVar.jF(this.cxf);
        }
    }

    public void b(com.baidu.tieba.homepage.framework.y yVar) {
        this.cxh = true;
        if (this.cxf != -1 && this.cxg) {
            yVar.jF(this.cxf);
        }
    }
}
