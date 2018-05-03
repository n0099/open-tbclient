package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dDh = -1;
    private boolean dDi = false;
    private boolean dDj = false;

    public void a(e eVar) {
        this.dDi = true;
        if (this.dDh != -1 && this.dDj) {
            eVar.ma(this.dDh);
        }
    }

    public void a(int i, e eVar) {
        this.dDh = i;
        if (this.dDi && this.dDj) {
            eVar.ma(this.dDh);
        }
    }
}
