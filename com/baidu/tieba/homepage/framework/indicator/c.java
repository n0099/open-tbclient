package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int edT = -1;
    private boolean edU = false;
    private boolean edV = false;

    public void a(e eVar) {
        this.edU = true;
        if (this.edT != -1 && this.edV) {
            eVar.oz(this.edT);
        }
    }

    public void a(int i, e eVar) {
        this.edT = i;
        if (this.edU && this.edV) {
            eVar.oz(this.edT);
        }
    }
}
