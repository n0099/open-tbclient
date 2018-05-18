package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aNK;
    private View.OnTouchListener aNL;

    public r HL() {
        return this.aNK;
    }

    public View.OnTouchListener HM() {
        return this.aNL;
    }

    public void onDestroy() {
        if (this.aNK != null) {
            this.aNK.HK();
        }
    }
}
