package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes16.dex */
public class b {
    private int ivx = -1;
    private boolean ivy = false;
    private boolean ivz = false;

    public void a(e eVar) {
        this.ivy = true;
        if (this.ivx != -1 && this.ivz) {
            eVar.xm(this.ivx);
        }
    }

    public void a(int i, e eVar) {
        this.ivx = i;
        if (this.ivy && this.ivz) {
            eVar.xm(this.ivx);
        }
    }
}
