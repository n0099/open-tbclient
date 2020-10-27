package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes22.dex */
public class b {
    private int jtT = -1;
    private boolean jtU = false;
    private boolean jtV = false;

    public void a(e eVar) {
        this.jtU = true;
        if (this.jtT != -1 && this.jtV) {
            eVar.Bg(this.jtT);
        }
    }

    public void a(int i, e eVar) {
        this.jtT = i;
        if (this.jtU && this.jtV) {
            eVar.Bg(this.jtT);
        }
    }
}
