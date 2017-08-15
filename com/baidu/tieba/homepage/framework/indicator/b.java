package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class b {
    private int cUn = -1;
    private boolean cUo = false;
    private boolean cUp = false;

    public void a(e eVar) {
        this.cUo = true;
        if (this.cUn != -1 && this.cUp) {
            eVar.kH(this.cUn);
        }
    }

    public void a(int i, e eVar) {
        this.cUn = i;
        if (this.cUo && this.cUp) {
            eVar.kH(this.cUn);
        }
    }

    public void b(e eVar) {
        this.cUp = true;
        if (this.cUn != -1 && this.cUo) {
            eVar.kH(this.cUn);
        }
    }
}
