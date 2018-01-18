package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r bBk;
    private View.OnTouchListener bBl;

    public r OE() {
        return this.bBk;
    }

    public View.OnTouchListener OF() {
        return this.bBl;
    }

    public void onDestroy() {
        if (this.bBk != null) {
            this.bBk.OD();
        }
    }
}
