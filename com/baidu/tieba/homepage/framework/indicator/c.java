package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int ghw = -1;
    private boolean ghx = false;
    private boolean ghy = false;

    public void a(e eVar) {
        this.ghx = true;
        if (this.ghw != -1 && this.ghy) {
            eVar.sM(this.ghw);
        }
    }

    public void a(int i, e eVar) {
        this.ghw = i;
        if (this.ghx && this.ghy) {
            eVar.sM(this.ghw);
        }
    }
}
