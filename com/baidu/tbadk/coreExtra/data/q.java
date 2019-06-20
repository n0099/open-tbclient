package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int cfh;
    private int cfi;
    private int cfj;

    public int alr() {
        return this.cfh == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.cfh;
    }

    public void oO(String str) {
        this.cfh = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int als() {
        return this.cfi;
    }

    public void oP(String str) {
        this.cfi = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int alt() {
        return this.cfj;
    }

    public void oQ(String str) {
        this.cfj = com.baidu.adp.lib.g.b.f(str, 0);
    }
}
