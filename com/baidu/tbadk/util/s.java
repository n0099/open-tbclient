package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aNl;
    private View.OnTouchListener aNm;

    public r Hr() {
        return this.aNl;
    }

    public View.OnTouchListener Hs() {
        return this.aNm;
    }

    public void onDestroy() {
        if (this.aNl != null) {
            this.aNl.Hq();
        }
    }
}
