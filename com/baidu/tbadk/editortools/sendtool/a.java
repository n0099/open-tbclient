package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 4);
        this.fCj = false;
        this.fCi = 2;
        this.fCk = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fBo = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fBo).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fBo != null && (this.fBo instanceof TextView)) {
            ((TextView) this.fBo).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fBo != null) {
            ((SendView) this.fBo).setTextColor(i);
        }
    }
}
