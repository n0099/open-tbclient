package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class b {
    private int cSo = -1;
    private boolean cSp = false;
    private boolean cSq = false;

    public void a(e eVar) {
        this.cSp = true;
        if (this.cSo != -1 && this.cSq) {
            eVar.kx(this.cSo);
        }
    }

    public void a(int i, e eVar) {
        this.cSo = i;
        if (this.cSp && this.cSq) {
            eVar.kx(this.cSo);
        }
    }

    public void b(e eVar) {
        this.cSq = true;
        if (this.cSo != -1 && this.cSp) {
            eVar.kx(this.cSo);
        }
    }
}
