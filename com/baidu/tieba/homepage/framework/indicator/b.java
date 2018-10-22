package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int elQ = -1;
    private boolean elR = false;
    private boolean elS = false;

    public void a(e eVar) {
        this.elR = true;
        if (this.elQ != -1 && this.elS) {
            eVar.nI(this.elQ);
        }
    }

    public void a(int i, e eVar) {
        this.elQ = i;
        if (this.elR && this.elS) {
            eVar.nI(this.elQ);
        }
    }
}
