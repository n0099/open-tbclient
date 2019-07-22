package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private w cDk;
    private View.OnTouchListener cmp;

    public w aww() {
        return this.cDk;
    }

    public View.OnTouchListener awx() {
        return this.cmp;
    }

    public void onDestroy() {
        if (this.cDk != null) {
            this.cDk.awv();
        }
    }
}
