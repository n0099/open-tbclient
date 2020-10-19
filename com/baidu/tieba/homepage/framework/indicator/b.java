package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes22.dex */
public class b {
    private int jhv = -1;
    private boolean jhw = false;
    private boolean jhx = false;

    public void a(e eVar) {
        this.jhw = true;
        if (this.jhv != -1 && this.jhx) {
            eVar.AN(this.jhv);
        }
    }

    public void a(int i, e eVar) {
        this.jhv = i;
        if (this.jhw && this.jhx) {
            eVar.AN(this.jhv);
        }
    }
}
