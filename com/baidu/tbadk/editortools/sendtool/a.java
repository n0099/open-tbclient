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
        this.elN = false;
        this.elM = 2;
        this.elO = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.ekV = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.ekV).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.ekV != null && (this.ekV instanceof TextView)) {
            ((TextView) this.ekV).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.ekV != null) {
            ((SendView) this.ekV).setTextColor(i);
        }
    }
}
