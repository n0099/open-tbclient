package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class q {
    private p aLY;
    private View.OnTouchListener aLZ;

    public p GS() {
        return this.aLY;
    }

    public View.OnTouchListener GT() {
        return this.aLZ;
    }

    public void onDestroy() {
        if (this.aLY != null) {
            this.aLY.GR();
        }
    }
}
