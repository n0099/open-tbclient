package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dDk = -1;
    private boolean dDl = false;
    private boolean dDm = false;

    public void a(e eVar) {
        this.dDl = true;
        if (this.dDk != -1 && this.dDm) {
            eVar.ma(this.dDk);
        }
    }

    public void a(int i, e eVar) {
        this.dDk = i;
        if (this.dDl && this.dDm) {
            eVar.ma(this.dDk);
        }
    }
}
