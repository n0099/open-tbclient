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
        this.fzU = false;
        this.fzT = 2;
        this.fzV = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fyZ = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fyZ).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fyZ != null && (this.fyZ instanceof TextView)) {
            ((TextView) this.fyZ).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fyZ != null) {
            ((SendView) this.fyZ).setTextColor(i);
        }
    }
}
