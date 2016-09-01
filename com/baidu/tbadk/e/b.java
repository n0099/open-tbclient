package com.baidu.tbadk.e;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener aif;
    private int aoC;
    private Drawable asZ;
    private String mTitle;

    public void setPosition(int i) {
        this.aoC = i;
    }

    public void setIcon(Drawable drawable) {
        this.asZ = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.aif = onClickListener;
    }
}
