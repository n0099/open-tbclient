package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int elP = -1;
    private boolean elQ = false;
    private boolean elR = false;

    public void a(e eVar) {
        this.elQ = true;
        if (this.elP != -1 && this.elR) {
            eVar.nI(this.elP);
        }
    }

    public void a(int i, e eVar) {
        this.elP = i;
        if (this.elQ && this.elR) {
            eVar.nI(this.elP);
        }
    }
}
