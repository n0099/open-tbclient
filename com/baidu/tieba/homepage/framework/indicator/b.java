package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes16.dex */
public class b {
    private int iJS = -1;
    private boolean iJT = false;
    private boolean iJU = false;

    public void a(e eVar) {
        this.iJT = true;
        if (this.iJS != -1 && this.iJU) {
            eVar.zG(this.iJS);
        }
    }

    public void a(int i, e eVar) {
        this.iJS = i;
        if (this.iJT && this.iJU) {
            eVar.zG(this.iJS);
        }
    }
}
