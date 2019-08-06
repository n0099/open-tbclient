package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int ggX = -1;
    private boolean ggY = false;
    private boolean ggZ = false;

    public void a(e eVar) {
        this.ggY = true;
        if (this.ggX != -1 && this.ggZ) {
            eVar.tO(this.ggX);
        }
    }

    public void a(int i, e eVar) {
        this.ggX = i;
        if (this.ggY && this.ggZ) {
            eVar.tO(this.ggX);
        }
    }
}
