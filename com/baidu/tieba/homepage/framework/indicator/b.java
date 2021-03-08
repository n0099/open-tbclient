package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int kgR = -1;
    private boolean kgS = false;
    private boolean kgT = false;

    public void a(e eVar) {
        this.kgS = true;
        if (this.kgR != -1 && this.kgT) {
            eVar.BG(this.kgR);
        }
    }

    public void a(int i, e eVar) {
        this.kgR = i;
        if (this.kgS && this.kgT) {
            eVar.BG(this.kgR);
        }
    }
}
