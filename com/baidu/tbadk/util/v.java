package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class v {
    private u bjC;
    private View.OnTouchListener bjD;

    public u QA() {
        return this.bjC;
    }

    public View.OnTouchListener QB() {
        return this.bjD;
    }

    public void onDestroy() {
        if (this.bjC != null) {
            this.bjC.Qz();
        }
    }
}
