package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener aew;
    private int akG;
    private Drawable apc;
    private String mTitle;

    public void setPosition(int i) {
        this.akG = i;
    }

    public void setIcon(Drawable drawable) {
        this.apc = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aew = onClickListener;
    }
}
