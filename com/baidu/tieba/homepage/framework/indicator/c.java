package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int eiE = -1;
    private boolean eiF = false;
    private boolean eiG = false;

    public void a(e eVar) {
        this.eiF = true;
        if (this.eiE != -1 && this.eiG) {
            eVar.oB(this.eiE);
        }
    }

    public void a(int i, e eVar) {
        this.eiE = i;
        if (this.eiF && this.eiG) {
            eVar.oB(this.eiE);
        }
    }
}
