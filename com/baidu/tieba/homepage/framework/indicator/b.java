package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int kbE = -1;
    private boolean kbF = false;
    private boolean kbG = false;

    public void a(e eVar) {
        this.kbF = true;
        if (this.kbE != -1 && this.kbG) {
            eVar.CU(this.kbE);
        }
    }

    public void a(int i, e eVar) {
        this.kbE = i;
        if (this.kbF && this.kbG) {
            eVar.CU(this.kbE);
        }
    }
}
