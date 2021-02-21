package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int keP = -1;
    private boolean keQ = false;
    private boolean keR = false;

    public void a(e eVar) {
        this.keQ = true;
        if (this.keP != -1 && this.keR) {
            eVar.BD(this.keP);
        }
    }

    public void a(int i, e eVar) {
        this.keP = i;
        if (this.keQ && this.keR) {
            eVar.BD(this.keP);
        }
    }
}
