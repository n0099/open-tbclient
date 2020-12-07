package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes22.dex */
public class b {
    private int jOo = -1;
    private boolean jOp = false;
    private boolean jOq = false;

    public void a(e eVar) {
        this.jOp = true;
        if (this.jOo != -1 && this.jOq) {
            eVar.CG(this.jOo);
        }
    }

    public void a(int i, e eVar) {
        this.jOo = i;
        if (this.jOp && this.jOq) {
            eVar.CG(this.jOo);
        }
    }
}
