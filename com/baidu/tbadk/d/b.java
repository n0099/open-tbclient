package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private Drawable apH;
    private int apI;
    private View.OnClickListener mClickListener;
    private String mTitle;

    public void setPosition(int i) {
        this.apI = i;
    }

    public void setIcon(Drawable drawable) {
        this.apH = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
