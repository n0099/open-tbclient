package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.l;
/* loaded from: classes.dex */
public class a extends l {
    public a(Context context) {
        super(context, (String) null, 4);
        this.dXz = false;
        this.dXy = 2;
        this.dXA = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.dWH = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.dWH).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.dWH != null && (this.dWH instanceof TextView)) {
            ((TextView) this.dWH).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.dWH != null) {
            ((SendView) this.dWH).setTextColor(i);
        }
    }
}
