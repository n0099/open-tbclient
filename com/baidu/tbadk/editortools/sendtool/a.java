package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.m;
/* loaded from: classes.dex */
public class a extends m {
    public a(Context context) {
        super(context, (String) null, 4);
        this.eNN = false;
        this.eNM = 2;
        this.eNO = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.eMS = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.eMS).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.eMS != null && (this.eMS instanceof TextView)) {
            ((TextView) this.eMS).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.eMS != null) {
            ((SendView) this.eMS).setTextColor(i);
        }
    }
}
