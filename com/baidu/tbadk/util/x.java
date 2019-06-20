package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private w cBT;
    private View.OnTouchListener clc;

    public w avn() {
        return this.cBT;
    }

    public View.OnTouchListener avo() {
        return this.clc;
    }

    public void onDestroy() {
        if (this.cBT != null) {
            this.cBT.avm();
        }
    }
}
