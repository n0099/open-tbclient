package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t aZW;
    private View.OnTouchListener aZX;

    public t MQ() {
        return this.aZW;
    }

    public View.OnTouchListener MR() {
        return this.aZX;
    }

    public void onDestroy() {
        if (this.aZW != null) {
            this.aZW.MP();
        }
    }
}
