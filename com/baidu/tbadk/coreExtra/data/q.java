package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int cgt;
    private int cgu;
    private int cgv;

    public int amy() {
        return this.cgt == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.cgt;
    }

    public void pf(String str) {
        this.cgt = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int amz() {
        return this.cgu;
    }

    public void pg(String str) {
        this.cgu = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int amA() {
        return this.cgv;
    }

    public void ph(String str) {
        this.cgv = com.baidu.adp.lib.g.b.f(str, 0);
    }
}
