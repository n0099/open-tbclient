package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class b {
    private int fKf = -1;
    private boolean fKg = false;
    private boolean fKh = false;

    public void a(e eVar) {
        this.fKg = true;
        if (this.fKf != -1 && this.fKh) {
            eVar.sr(this.fKf);
        }
    }

    public void a(int i, e eVar) {
        this.fKf = i;
        if (this.fKg && this.fKh) {
            eVar.sr(this.fKf);
        }
    }
}
