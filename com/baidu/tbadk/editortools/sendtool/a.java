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
        this.dxs = false;
        this.dxr = 2;
        this.dxt = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.dwA = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.dwA).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.dwA != null && (this.dwA instanceof TextView)) {
            ((TextView) this.dwA).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.dwA != null) {
            ((SendView) this.dwA).setTextColor(i);
        }
    }
}
