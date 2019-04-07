package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class b {
    private int fJT = -1;
    private boolean fJU = false;
    private boolean fJV = false;

    public void a(e eVar) {
        this.fJU = true;
        if (this.fJT != -1 && this.fJV) {
            eVar.sn(this.fJT);
        }
    }

    public void a(int i, e eVar) {
        this.fJT = i;
        if (this.fJU && this.fJV) {
            eVar.sn(this.fJT);
        }
    }
}
