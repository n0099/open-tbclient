package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int gbc = -1;
    private boolean gbd = false;
    private boolean gbe = false;

    public void a(e eVar) {
        this.gbd = true;
        if (this.gbc != -1 && this.gbe) {
            eVar.tu(this.gbc);
        }
    }

    public void a(int i, e eVar) {
        this.gbc = i;
        if (this.gbd && this.gbe) {
            eVar.tu(this.gbc);
        }
    }
}
