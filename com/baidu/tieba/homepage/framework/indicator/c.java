package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int ecI = -1;
    private boolean ecJ = false;
    private boolean ecK = false;

    public void a(e eVar) {
        this.ecJ = true;
        if (this.ecI != -1 && this.ecK) {
            eVar.oG(this.ecI);
        }
    }

    public void a(int i, e eVar) {
        this.ecI = i;
        if (this.ecJ && this.ecK) {
            eVar.oG(this.ecI);
        }
    }
}
