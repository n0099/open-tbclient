package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class b {
    private int cQV = -1;
    private boolean cQW = false;
    private boolean cQX = false;

    public void a(e eVar) {
        this.cQW = true;
        if (this.cQV != -1 && this.cQX) {
            eVar.kx(this.cQV);
        }
    }

    public void a(int i, e eVar) {
        this.cQV = i;
        if (this.cQW && this.cQX) {
            eVar.kx(this.cQV);
        }
    }

    public void b(e eVar) {
        this.cQX = true;
        if (this.cQV != -1 && this.cQW) {
            eVar.kx(this.cQV);
        }
    }
}
