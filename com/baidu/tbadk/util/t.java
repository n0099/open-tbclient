package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class t {
    private s aWC;
    private View.OnTouchListener aWD;

    public s Lz() {
        return this.aWC;
    }

    public View.OnTouchListener LA() {
        return this.aWD;
    }

    public void onDestroy() {
        if (this.aWC != null) {
            this.aWC.Ly();
        }
    }
}
