package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes22.dex */
public class b {
    private int jOq = -1;
    private boolean jOr = false;
    private boolean jOs = false;

    public void a(e eVar) {
        this.jOr = true;
        if (this.jOq != -1 && this.jOs) {
            eVar.CG(this.jOq);
        }
    }

    public void a(int i, e eVar) {
        this.jOq = i;
        if (this.jOr && this.jOs) {
            eVar.CG(this.jOq);
        }
    }
}
