package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int ggh = -1;
    private boolean ggi = false;
    private boolean ggj = false;

    public void a(e eVar) {
        this.ggi = true;
        if (this.ggh != -1 && this.ggj) {
            eVar.tM(this.ggh);
        }
    }

    public void a(int i, e eVar) {
        this.ggh = i;
        if (this.ggi && this.ggj) {
            eVar.tM(this.ggh);
        }
    }
}
