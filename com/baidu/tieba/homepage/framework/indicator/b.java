package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes6.dex */
public class b {
    private int exH = -1;
    private boolean exI = false;
    private boolean exJ = false;

    public void a(e eVar) {
        this.exI = true;
        if (this.exH != -1 && this.exJ) {
            eVar.oI(this.exH);
        }
    }

    public void a(int i, e eVar) {
        this.exH = i;
        if (this.exI && this.exJ) {
            eVar.oI(this.exH);
        }
    }
}
