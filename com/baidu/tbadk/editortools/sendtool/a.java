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
        this.eLw = false;
        this.eLv = 2;
        this.eLx = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.eKB = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.eKB).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.eKB != null && (this.eKB instanceof TextView)) {
            ((TextView) this.eKB).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.eKB != null) {
            ((SendView) this.eKB).setTextColor(i);
        }
    }
}
