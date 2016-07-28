package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener afk;
    private int alw;
    private Drawable apS;
    private String mTitle;

    public void setPosition(int i) {
        this.alw = i;
    }

    public void setIcon(Drawable drawable) {
        this.apS = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.afk = onClickListener;
    }
}
