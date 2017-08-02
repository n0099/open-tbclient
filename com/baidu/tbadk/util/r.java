package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private q aLC;
    private View.OnTouchListener aLD;

    public q Hh() {
        return this.aLC;
    }

    public View.OnTouchListener Hi() {
        return this.aLD;
    }

    public void onDestroy() {
        if (this.aLC != null) {
            this.aLC.Hg();
        }
    }
}
