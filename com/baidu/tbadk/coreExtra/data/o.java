package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int atn;
    private int ato;
    private int atp;

    public int yE() {
        return this.atn == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.atn;
    }

    public void fb(String str) {
        this.atn = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yF() {
        return this.ato;
    }

    public void fc(String str) {
        this.ato = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yG() {
        return this.atp;
    }

    public void fd(String str) {
        this.atp = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
