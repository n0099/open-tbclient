package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dSQ = -1;
    private boolean dSR = false;
    private boolean dSS = false;

    public void a(e eVar) {
        this.dSR = true;
        if (this.dSQ != -1 && this.dSS) {
            eVar.ms(this.dSQ);
        }
    }

    public void a(int i, e eVar) {
        this.dSQ = i;
        if (this.dSR && this.dSS) {
            eVar.ms(this.dSQ);
        }
    }
}
