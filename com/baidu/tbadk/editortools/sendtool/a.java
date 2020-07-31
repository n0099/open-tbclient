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
        this.eAT = false;
        this.eAS = 2;
        this.eAU = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.ezZ = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.ezZ).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.ezZ != null && (this.ezZ instanceof TextView)) {
            ((TextView) this.ezZ).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.ezZ != null) {
            ((SendView) this.ezZ).setTextColor(i);
        }
    }
}
