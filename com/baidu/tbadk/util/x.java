package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private View.OnTouchListener ccW;
    private w ctI;

    public w aqi() {
        return this.ctI;
    }

    public View.OnTouchListener aqj() {
        return this.ccW;
    }

    public void onDestroy() {
        if (this.ctI != null) {
            this.ctI.aqh();
        }
    }
}
