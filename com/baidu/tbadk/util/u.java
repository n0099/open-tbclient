package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t biO;
    private View.OnTouchListener biP;

    public t Qf() {
        return this.biO;
    }

    public View.OnTouchListener Qg() {
        return this.biP;
    }

    public void onDestroy() {
        if (this.biO != null) {
            this.biO.Qe();
        }
    }
}
