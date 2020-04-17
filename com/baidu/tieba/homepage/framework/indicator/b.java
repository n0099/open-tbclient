package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int hLA = -1;
    private boolean hLB = false;
    private boolean hLC = false;

    public void a(e eVar) {
        this.hLB = true;
        if (this.hLA != -1 && this.hLC) {
            eVar.vG(this.hLA);
        }
    }

    public void a(int i, e eVar) {
        this.hLA = i;
        if (this.hLB && this.hLC) {
            eVar.vG(this.hLA);
        }
    }
}
