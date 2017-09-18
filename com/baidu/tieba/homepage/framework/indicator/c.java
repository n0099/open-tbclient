package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dbK = -1;
    private boolean dbL = false;
    private boolean dbM = false;

    public void a(e eVar) {
        this.dbL = true;
        if (this.dbK != -1 && this.dbM) {
            eVar.kX(this.dbK);
        }
    }

    public void a(int i, e eVar) {
        this.dbK = i;
        if (this.dbL && this.dbM) {
            eVar.kX(this.dbK);
        }
    }

    public void b(e eVar) {
        this.dbM = true;
        if (this.dbK != -1 && this.dbL) {
            eVar.kX(this.dbK);
        }
    }
}
