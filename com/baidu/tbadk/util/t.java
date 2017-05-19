package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class t {
    private s aJs;
    private View.OnTouchListener aJt;

    public s GB() {
        return this.aJs;
    }

    public View.OnTouchListener GC() {
        return this.aJt;
    }

    public void onDestroy() {
        if (this.aJs != null) {
            this.aJs.GA();
        }
    }
}
