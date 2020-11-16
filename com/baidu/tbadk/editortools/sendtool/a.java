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
        this.fns = false;
        this.fnr = 2;
        this.fnt = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fmx = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fmx).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fmx != null && (this.fmx instanceof TextView)) {
            ((TextView) this.fmx).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fmx != null) {
            ((SendView) this.fmx).setTextColor(i);
        }
    }
}
