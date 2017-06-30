package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class u {
    private t aKu;
    private View.OnTouchListener aKv;

    public t GS() {
        return this.aKu;
    }

    public View.OnTouchListener GT() {
        return this.aKv;
    }

    public void onDestroy() {
        if (this.aKu != null) {
            this.aKu.GR();
        }
    }
}
