package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes.dex */
public class c {
    private int dgJ = -1;
    private boolean dgK = false;
    private boolean dgL = false;

    public void a(e eVar) {
        this.dgK = true;
        if (this.dgJ != -1 && this.dgL) {
            eVar.lk(this.dgJ);
        }
    }

    public void a(int i, e eVar) {
        this.dgJ = i;
        if (this.dgK && this.dgL) {
            eVar.lk(this.dgJ);
        }
    }
}
