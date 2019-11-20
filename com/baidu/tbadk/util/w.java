package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class w {
    private v cOx;
    private View.OnTouchListener czy;

    public v axL() {
        return this.cOx;
    }

    public View.OnTouchListener axM() {
        return this.czy;
    }

    public void onDestroy() {
        if (this.cOx != null) {
            this.cOx.axK();
        }
    }
}
