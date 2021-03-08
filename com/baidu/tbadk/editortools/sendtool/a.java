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
        this.fDI = false;
        this.fDH = 2;
        this.fDJ = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.fCN = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.fCN).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.fCN != null && (this.fCN instanceof TextView)) {
            ((TextView) this.fCN).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.fCN != null) {
            ((SendView) this.fCN).setTextColor(i);
        }
    }
}
