package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes2.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 4);
        this.eLs = false;
        this.eLr = 2;
        this.eLt = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.eKx = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.eKx).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.eKx != null && (this.eKx instanceof TextView)) {
            ((TextView) this.eKx).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.eKx != null) {
            ((SendView) this.eKx).setTextColor(i);
        }
    }
}
