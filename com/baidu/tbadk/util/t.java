package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class t {
    private s aVH;
    private View.OnTouchListener aVI;

    public s Lh() {
        return this.aVH;
    }

    public View.OnTouchListener Li() {
        return this.aVI;
    }

    public void onDestroy() {
        if (this.aVH != null) {
            this.aVH.Lg();
        }
    }
}
