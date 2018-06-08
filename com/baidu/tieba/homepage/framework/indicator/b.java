package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int dPy = -1;
    private boolean dPz = false;
    private boolean dPA = false;

    public void a(e eVar) {
        this.dPz = true;
        if (this.dPy != -1 && this.dPA) {
            eVar.ml(this.dPy);
        }
    }

    public void a(int i, e eVar) {
        this.dPy = i;
        if (this.dPz && this.dPA) {
            eVar.ml(this.dPy);
        }
    }
}
