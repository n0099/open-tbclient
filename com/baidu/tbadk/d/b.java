package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private int anc;
    private Drawable ark;
    private View.OnClickListener mClickListener;
    private String mTitle;

    public void setPosition(int i) {
        this.anc = i;
    }

    public void setIcon(Drawable drawable) {
        this.ark = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void d(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }
}
