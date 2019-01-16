package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int exG = -1;
    private boolean exH = false;
    private boolean exI = false;

    public void a(e eVar) {
        this.exH = true;
        if (this.exG != -1 && this.exI) {
            eVar.oI(this.exG);
        }
    }

    public void a(int i, e eVar) {
        this.exG = i;
        if (this.exH && this.exI) {
            eVar.oI(this.exG);
        }
    }
}
