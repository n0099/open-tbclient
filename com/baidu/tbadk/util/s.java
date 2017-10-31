package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private View.OnTouchListener aMA;
    private r aMz;

    public r GY() {
        return this.aMz;
    }

    public View.OnTouchListener GZ() {
        return this.aMA;
    }

    public void onDestroy() {
        if (this.aMz != null) {
            this.aMz.GX();
        }
    }
}
