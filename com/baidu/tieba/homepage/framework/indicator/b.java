package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int keB = -1;
    private boolean keC = false;
    private boolean keD = false;

    public void a(e eVar) {
        this.keC = true;
        if (this.keB != -1 && this.keD) {
            eVar.BD(this.keB);
        }
    }

    public void a(int i, e eVar) {
        this.keB = i;
        if (this.keC && this.keD) {
            eVar.BD(this.keB);
        }
    }
}
