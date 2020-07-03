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
        this.euA = false;
        this.euz = 2;
        this.euB = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.etH = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.etH).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.etH != null && (this.etH instanceof TextView)) {
            ((TextView) this.etH).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.etH != null) {
            ((SendView) this.etH).setTextColor(i);
        }
    }
}
