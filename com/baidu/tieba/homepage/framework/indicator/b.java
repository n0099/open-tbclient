package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes9.dex */
public class b {
    private int iah = -1;
    private boolean iai = false;
    private boolean iaj = false;

    public void a(e eVar) {
        this.iai = true;
        if (this.iah != -1 && this.iaj) {
            eVar.wm(this.iah);
        }
    }

    public void a(int i, e eVar) {
        this.iah = i;
        if (this.iai && this.iaj) {
            eVar.wm(this.iah);
        }
    }
}
