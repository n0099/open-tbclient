package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private q aMw;
    private View.OnTouchListener aMx;

    public q Ho() {
        return this.aMw;
    }

    public View.OnTouchListener Hp() {
        return this.aMx;
    }

    public void onDestroy() {
        if (this.aMw != null) {
            this.aMw.Hn();
        }
    }
}
