package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aMH;
    private View.OnTouchListener aMI;

    public r Hj() {
        return this.aMH;
    }

    public View.OnTouchListener Hk() {
        return this.aMI;
    }

    public void onDestroy() {
        if (this.aMH != null) {
            this.aMH.Hi();
        }
    }
}
