package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener OZ;
    private int aom;
    private Drawable asx;
    private String mTitle;

    public void setPosition(int i) {
        this.aom = i;
    }

    public void setIcon(Drawable drawable) {
        this.asx = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.OZ = onClickListener;
    }
}
