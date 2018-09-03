package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dWE = -1;
    private boolean dWF = false;
    private boolean dWG = false;

    public void a(e eVar) {
        this.dWF = true;
        if (this.dWE != -1 && this.dWG) {
            eVar.mG(this.dWE);
        }
    }

    public void a(int i, e eVar) {
        this.dWE = i;
        if (this.dWF && this.dWG) {
            eVar.mG(this.dWE);
        }
    }
}
