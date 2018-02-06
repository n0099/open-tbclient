package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int eiA = -1;
    private boolean eiB = false;
    private boolean eiC = false;

    public void a(e eVar) {
        this.eiB = true;
        if (this.eiA != -1 && this.eiC) {
            eVar.oA(this.eiA);
        }
    }

    public void a(int i, e eVar) {
        this.eiA = i;
        if (this.eiB && this.eiC) {
            eVar.oA(this.eiA);
        }
    }
}
