package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes2.dex */
public class b {
    private int jWZ = -1;
    private boolean jXa = false;
    private boolean jXb = false;

    public void a(e eVar) {
        this.jXa = true;
        if (this.jWZ != -1 && this.jXb) {
            eVar.Bo(this.jWZ);
        }
    }

    public void a(int i, e eVar) {
        this.jWZ = i;
        if (this.jXa && this.jXb) {
            eVar.Bo(this.jWZ);
        }
    }
}
