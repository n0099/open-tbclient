package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int cXX = -1;
    private boolean cXY = false;
    private boolean cXZ = false;

    public void a(e eVar) {
        this.cXY = true;
        if (this.cXX != -1 && this.cXZ) {
            eVar.kS(this.cXX);
        }
    }

    public void a(int i, e eVar) {
        this.cXX = i;
        if (this.cXY && this.cXZ) {
            eVar.kS(this.cXX);
        }
    }
}
