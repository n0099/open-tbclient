package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class b {
    private int fKg = -1;
    private boolean fKh = false;
    private boolean fKi = false;

    public void a(e eVar) {
        this.fKh = true;
        if (this.fKg != -1 && this.fKi) {
            eVar.sr(this.fKg);
        }
    }

    public void a(int i, e eVar) {
        this.fKg = i;
        if (this.fKh && this.fKi) {
            eVar.sr(this.fKg);
        }
    }
}
