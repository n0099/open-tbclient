package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private q aMR;
    private View.OnTouchListener aMS;

    public q Hp() {
        return this.aMR;
    }

    public View.OnTouchListener Hq() {
        return this.aMS;
    }

    public void onDestroy() {
        if (this.aMR != null) {
            this.aMR.Ho();
        }
    }
}
