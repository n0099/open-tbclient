package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dWH = -1;
    private boolean dWI = false;
    private boolean dWJ = false;

    public void a(e eVar) {
        this.dWI = true;
        if (this.dWH != -1 && this.dWJ) {
            eVar.mG(this.dWH);
        }
    }

    public void a(int i, e eVar) {
        this.dWH = i;
        if (this.dWI && this.dWJ) {
            eVar.mG(this.dWH);
        }
    }
}
