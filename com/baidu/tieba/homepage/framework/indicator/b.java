package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int iaU = -1;
    private boolean iaV = false;
    private boolean iaW = false;

    public void a(e eVar) {
        this.iaV = true;
        if (this.iaU != -1 && this.iaW) {
            eVar.wo(this.iaU);
        }
    }

    public void a(int i, e eVar) {
        this.iaU = i;
        if (this.iaV && this.iaW) {
            eVar.wo(this.iaU);
        }
    }
}
