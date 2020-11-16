package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes21.dex */
public class b {
    private int jAM = -1;
    private boolean jAN = false;
    private boolean jAO = false;

    public void a(e eVar) {
        this.jAN = true;
        if (this.jAM != -1 && this.jAO) {
            eVar.BR(this.jAM);
        }
    }

    public void a(int i, e eVar) {
        this.jAM = i;
        if (this.jAN && this.jAO) {
            eVar.BR(this.jAM);
        }
    }
}
