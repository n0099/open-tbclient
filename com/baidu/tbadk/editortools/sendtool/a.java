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
        this.dxr = false;
        this.dxq = 2;
        this.dxs = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.dwz = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.dwz).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.dwz != null && (this.dwz instanceof TextView)) {
            ((TextView) this.dwz).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.dwz != null) {
            ((SendView) this.dwz).setTextColor(i);
        }
    }
}
