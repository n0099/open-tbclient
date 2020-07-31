package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes16.dex */
public class b {
    private int ivv = -1;
    private boolean ivw = false;
    private boolean ivx = false;

    public void a(e eVar) {
        this.ivw = true;
        if (this.ivv != -1 && this.ivx) {
            eVar.xm(this.ivv);
        }
    }

    public void a(int i, e eVar) {
        this.ivv = i;
        if (this.ivw && this.ivx) {
            eVar.xm(this.ivv);
        }
    }
}
