package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes16.dex */
public class b {
    private int iJM = -1;
    private boolean iJN = false;
    private boolean iJO = false;

    public void a(e eVar) {
        this.iJN = true;
        if (this.iJM != -1 && this.iJO) {
            eVar.zG(this.iJM);
        }
    }

    public void a(int i, e eVar) {
        this.iJM = i;
        if (this.iJN && this.iJO) {
            eVar.zG(this.iJM);
        }
    }
}
