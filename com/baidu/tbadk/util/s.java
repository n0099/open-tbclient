package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aNo;
    private View.OnTouchListener aNp;

    public r Hr() {
        return this.aNo;
    }

    public View.OnTouchListener Hs() {
        return this.aNp;
    }

    public void onDestroy() {
        if (this.aNo != null) {
            this.aNo.Hq();
        }
    }
}
