package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private View.OnTouchListener aMA;
    private q aMz;

    public q Ho() {
        return this.aMz;
    }

    public View.OnTouchListener Hp() {
        return this.aMA;
    }

    public void onDestroy() {
        if (this.aMz != null) {
            this.aMz.Hn();
        }
    }
}
