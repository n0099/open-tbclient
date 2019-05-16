package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private w cBS;
    private View.OnTouchListener clb;

    public w avn() {
        return this.cBS;
    }

    public View.OnTouchListener avo() {
        return this.clb;
    }

    public void onDestroy() {
        if (this.cBS != null) {
            this.cBS.avm();
        }
    }
}
