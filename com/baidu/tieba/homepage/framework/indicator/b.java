package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes22.dex */
public class b {
    private int jzQ = -1;
    private boolean jzR = false;
    private boolean jzS = false;

    public void a(e eVar) {
        this.jzR = true;
        if (this.jzQ != -1 && this.jzS) {
            eVar.Bt(this.jzQ);
        }
    }

    public void a(int i, e eVar) {
        this.jzQ = i;
        if (this.jzR && this.jzS) {
            eVar.Bt(this.jzQ);
        }
    }
}
