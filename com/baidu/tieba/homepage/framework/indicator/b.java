package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int hLG = -1;
    private boolean hLH = false;
    private boolean hLI = false;

    public void a(e eVar) {
        this.hLH = true;
        if (this.hLG != -1 && this.hLI) {
            eVar.vG(this.hLG);
        }
    }

    public void a(int i, e eVar) {
        this.hLG = i;
        if (this.hLH && this.hLI) {
            eVar.vG(this.hLG);
        }
    }
}
