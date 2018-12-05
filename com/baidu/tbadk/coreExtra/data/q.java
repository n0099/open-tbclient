package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class q {
    private int aOe;
    private int aOf;
    private int aOg;

    public int GO() {
        return this.aOe == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aOe;
    }

    public void gE(String str) {
        this.aOe = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int GP() {
        return this.aOf;
    }

    public void gF(String str) {
        this.aOf = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int GQ() {
        return this.aOg;
    }

    public void gG(String str) {
        this.aOg = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
