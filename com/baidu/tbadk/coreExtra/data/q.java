package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int cfg;
    private int cfh;
    private int cfi;

    public int alr() {
        return this.cfg == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.cfg;
    }

    public void oP(String str) {
        this.cfg = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int als() {
        return this.cfh;
    }

    public void oQ(String str) {
        this.cfh = com.baidu.adp.lib.g.b.f(str, 0);
    }

    public int alt() {
        return this.cfi;
    }

    public void oR(String str) {
        this.cfi = com.baidu.adp.lib.g.b.f(str, 0);
    }
}
