package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int cYj = -1;
    private boolean cYk = false;
    private boolean cYl = false;

    public void a(e eVar) {
        this.cYk = true;
        if (this.cYj != -1 && this.cYl) {
            eVar.kT(this.cYj);
        }
    }

    public void a(int i, e eVar) {
        this.cYj = i;
        if (this.cYk && this.cYl) {
            eVar.kT(this.cYj);
        }
    }
}
