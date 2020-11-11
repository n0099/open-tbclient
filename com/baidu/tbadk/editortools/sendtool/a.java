package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 4);
        this.fok = false;
        this.foj = 2;
        this.fol = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fnp = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fnp).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fnp != null && (this.fnp instanceof TextView)) {
            ((TextView) this.fnp).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fnp != null) {
            ((SendView) this.fnp).setTextColor(i);
        }
    }
}
