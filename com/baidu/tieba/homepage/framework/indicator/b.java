package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dEn = -1;
    private boolean dEo = false;
    private boolean dEp = false;

    public void a(e eVar) {
        this.dEo = true;
        if (this.dEn != -1 && this.dEp) {
            eVar.lZ(this.dEn);
        }
    }

    public void a(int i, e eVar) {
        this.dEn = i;
        if (this.dEo && this.dEp) {
            eVar.lZ(this.dEn);
        }
    }
}
