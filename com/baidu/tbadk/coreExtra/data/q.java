package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int cgm;
    private int cgn;
    private int cgo;

    public int amw() {
        return this.cgm == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.cgm;
    }

    public void pf(String str) {
        this.cgm = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int amx() {
        return this.cgn;
    }

    public void pg(String str) {
        this.cgn = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int amy() {
        return this.cgo;
    }

    public void ph(String str) {
        this.cgo = com.baidu.adp.lib.g.b.f(str, 0);
    }
}
