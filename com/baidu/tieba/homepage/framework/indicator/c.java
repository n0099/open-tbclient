package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int daQ = -1;
    private boolean daR = false;
    private boolean daS = false;

    public void a(e eVar) {
        this.daR = true;
        if (this.daQ != -1 && this.daS) {
            eVar.kV(this.daQ);
        }
    }

    public void a(int i, e eVar) {
        this.daQ = i;
        if (this.daR && this.daS) {
            eVar.kV(this.daQ);
        }
    }

    public void b(e eVar) {
        this.daS = true;
        if (this.daQ != -1 && this.daR) {
            eVar.kV(this.daQ);
        }
    }
}
