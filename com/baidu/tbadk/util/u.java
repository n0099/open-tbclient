package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t bey;
    private View.OnTouchListener bez;

    public t OO() {
        return this.bey;
    }

    public View.OnTouchListener OP() {
        return this.bez;
    }

    public void onDestroy() {
        if (this.bey != null) {
            this.bey.ON();
        }
    }
}
