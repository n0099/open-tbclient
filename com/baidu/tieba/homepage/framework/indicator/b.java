package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int hbK = -1;
    private boolean hbL = false;
    private boolean hbM = false;

    public void a(e eVar) {
        this.hbL = true;
        if (this.hbK != -1 && this.hbM) {
            eVar.vi(this.hbK);
        }
    }

    public void a(int i, e eVar) {
        this.hbK = i;
        if (this.hbL && this.hbM) {
            eVar.vi(this.hbK);
        }
    }
}
