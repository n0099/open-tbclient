package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class r {
    private q aMT;
    private View.OnTouchListener aMU;

    public q Hp() {
        return this.aMT;
    }

    public View.OnTouchListener Hq() {
        return this.aMU;
    }

    public void onDestroy() {
        if (this.aMT != null) {
            this.aMT.Ho();
        }
    }
}
