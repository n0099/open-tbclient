package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t bfl;
    private View.OnTouchListener bfm;

    public t OX() {
        return this.bfl;
    }

    public View.OnTouchListener OY() {
        return this.bfm;
    }

    public void onDestroy() {
        if (this.bfl != null) {
            this.bfl.OW();
        }
    }
}
