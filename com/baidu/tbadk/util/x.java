package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class x {
    private View.OnTouchListener ccX;
    private w ctJ;

    public w aqi() {
        return this.ctJ;
    }

    public View.OnTouchListener aqj() {
        return this.ccX;
    }

    public void onDestroy() {
        if (this.ctJ != null) {
            this.ctJ.aqh();
        }
    }
}
