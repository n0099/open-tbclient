package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dgp = -1;
    private boolean dgq = false;
    private boolean dgr = false;

    public void a(e eVar) {
        this.dgq = true;
        if (this.dgp != -1 && this.dgr) {
            eVar.lk(this.dgp);
        }
    }

    public void a(int i, e eVar) {
        this.dgp = i;
        if (this.dgq && this.dgr) {
            eVar.lk(this.dgp);
        }
    }
}
