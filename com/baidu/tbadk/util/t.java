package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class t {
    private s aJf;
    private View.OnTouchListener aJg;

    public s Gv() {
        return this.aJf;
    }

    public View.OnTouchListener Gw() {
        return this.aJg;
    }

    public void onDestroy() {
        if (this.aJf != null) {
            this.aJf.Gu();
        }
    }
}
