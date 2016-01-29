package com.baidu.tbadk.d;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b implements c {
    private View.OnClickListener OS;
    private int anV;
    private Drawable asd;
    private String mTitle;

    public void setPosition(int i) {
        this.anV = i;
    }

    public void setIcon(Drawable drawable) {
        this.asd = drawable;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void h(View.OnClickListener onClickListener) {
        this.OS = onClickListener;
    }
}
