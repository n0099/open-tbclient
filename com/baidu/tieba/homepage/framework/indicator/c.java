package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class c {
    private int eio = -1;
    private boolean eip = false;
    private boolean eiq = false;

    public void a(e eVar) {
        this.eip = true;
        if (this.eio != -1 && this.eiq) {
            eVar.oA(this.eio);
        }
    }

    public void a(int i, e eVar) {
        this.eio = i;
        if (this.eip && this.eiq) {
            eVar.oA(this.eio);
        }
    }
}
