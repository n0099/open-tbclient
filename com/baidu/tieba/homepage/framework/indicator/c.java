package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.e;
/* loaded from: classes4.dex */
public class c {
    private int gio = -1;
    private boolean gip = false;
    private boolean giq = false;

    public void a(e eVar) {
        this.gip = true;
        if (this.gio != -1 && this.giq) {
            eVar.sN(this.gio);
        }
    }

    public void a(int i, e eVar) {
        this.gio = i;
        if (this.gip && this.giq) {
            eVar.sN(this.gio);
        }
    }
}
