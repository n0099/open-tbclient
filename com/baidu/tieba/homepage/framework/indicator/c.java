package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int giQ = -1;
    private boolean giR = false;
    private boolean giS = false;

    public void a(e eVar) {
        this.giR = true;
        if (this.giQ != -1 && this.giS) {
            eVar.tS(this.giQ);
        }
    }

    public void a(int i, e eVar) {
        this.giQ = i;
        if (this.giR && this.giS) {
            eVar.tS(this.giQ);
        }
    }
}
