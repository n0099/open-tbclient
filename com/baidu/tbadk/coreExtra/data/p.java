package com.baidu.tbadk.coreExtra.data;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes.dex */
public class p {
    private int aFm;
    private int aFn;
    private int aFo;

    public int Dx() {
        return this.aFm == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.aFm;
    }

    public void fW(String str) {
        this.aFm = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int Dy() {
        return this.aFn;
    }

    public void fX(String str) {
        this.aFn = com.baidu.adp.lib.g.b.l(str, 0);
    }

    public int Dz() {
        return this.aFo;
    }

    public void fY(String str) {
        this.aFo = com.baidu.adp.lib.g.b.l(str, 0);
    }
}
