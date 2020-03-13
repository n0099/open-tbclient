package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int haC = -1;
    private boolean haD = false;
    private boolean haE = false;

    public void a(e eVar) {
        this.haD = true;
        if (this.haC != -1 && this.haE) {
            eVar.vb(this.haC);
        }
    }

    public void a(int i, e eVar) {
        this.haC = i;
        if (this.haD && this.haE) {
            eVar.vb(this.haC);
        }
    }
}
