package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes21.dex */
public class b {
    private int iSy = -1;
    private boolean iSz = false;
    private boolean iSA = false;

    public void a(e eVar) {
        this.iSz = true;
        if (this.iSy != -1 && this.iSA) {
            eVar.Ah(this.iSy);
        }
    }

    public void a(int i, e eVar) {
        this.iSy = i;
        if (this.iSz && this.iSA) {
            eVar.Ah(this.iSy);
        }
    }
}
