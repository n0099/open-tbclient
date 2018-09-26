package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int edW = -1;
    private boolean edX = false;
    private boolean edY = false;

    public void a(e eVar) {
        this.edX = true;
        if (this.edW != -1 && this.edY) {
            eVar.nk(this.edW);
        }
    }

    public void a(int i, e eVar) {
        this.edW = i;
        if (this.edX && this.edY) {
            eVar.nk(this.edW);
        }
    }
}
