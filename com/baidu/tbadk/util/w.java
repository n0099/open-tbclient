package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class w {
    private v cEi;
    private View.OnTouchListener cnr;

    public v awK() {
        return this.cEi;
    }

    public View.OnTouchListener awL() {
        return this.cnr;
    }

    public void onDestroy() {
        if (this.cEi != null) {
            this.cEi.awJ();
        }
    }
}
