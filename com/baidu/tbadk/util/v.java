package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class v {
    private u bjB;
    private View.OnTouchListener bjC;

    public u QA() {
        return this.bjB;
    }

    public View.OnTouchListener QB() {
        return this.bjC;
    }

    public void onDestroy() {
        if (this.bjB != null) {
            this.bjB.Qz();
        }
    }
}
