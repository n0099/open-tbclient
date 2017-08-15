package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private q aMS;
    private View.OnTouchListener aMT;

    public q Hp() {
        return this.aMS;
    }

    public View.OnTouchListener Hq() {
        return this.aMT;
    }

    public void onDestroy() {
        if (this.aMS != null) {
            this.aMS.Ho();
        }
    }
}
