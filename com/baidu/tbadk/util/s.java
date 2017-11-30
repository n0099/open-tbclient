package com.baidu.tbadk.util;

import android.view.View;
/* loaded from: classes.dex */
public class s {
    private r aNi;
    private View.OnTouchListener aNj;

    public r Hq() {
        return this.aNi;
    }

    public View.OnTouchListener Hr() {
        return this.aNj;
    }

    public void onDestroy() {
        if (this.aNi != null) {
            this.aNi.Hp();
        }
    }
}
