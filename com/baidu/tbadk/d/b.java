package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener Fn;
    private int aka;
    private Drawable aoo;
    private String mTitle;

    public void setPosition(int i) {
        this.aka = i;
    }

    public void setIcon(Drawable drawable) {
        this.aoo = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.Fn = onClickListener;
    }
}
