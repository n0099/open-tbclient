package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dpp = -1;
    private boolean dpq = false;
    private boolean dpr = false;

    public void a(e eVar) {
        this.dpq = true;
        if (this.dpp != -1 && this.dpr) {
            eVar.lI(this.dpp);
        }
    }

    public void a(int i, e eVar) {
        this.dpp = i;
        if (this.dpq && this.dpr) {
            eVar.lI(this.dpp);
        }
    }
}
