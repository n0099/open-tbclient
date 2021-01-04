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
        this.fEC = false;
        this.fEB = 2;
        this.fED = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fDH = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fDH).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fDH != null && (this.fDH instanceof TextView)) {
            ((TextView) this.fDH).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fDH != null) {
            ((SendView) this.fDH).setTextColor(i);
        }
    }
}
