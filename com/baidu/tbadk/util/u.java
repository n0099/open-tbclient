package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t biL;
    private View.OnTouchListener biM;

    public t Qd() {
        return this.biL;
    }

    public View.OnTouchListener Qe() {
        return this.biM;
    }

    public void onDestroy() {
        if (this.biL != null) {
            this.biL.Qc();
        }
    }
}
