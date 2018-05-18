package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class o {
    private int ato;
    private int atp;
    private int atq;

    public int yD() {
        return this.ato == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.ato;
    }

    public void fb(String str) {
        this.ato = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yE() {
        return this.atp;
    }

    public void fc(String str) {
        this.atp = com.baidu.adp.lib.g.b.g(str, 0);
    }

    public int yF() {
        return this.atq;
    }

    public void fd(String str) {
        this.atq = com.baidu.adp.lib.g.b.g(str, 0);
    }
}
