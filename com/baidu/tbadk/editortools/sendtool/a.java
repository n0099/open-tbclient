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
        this.dtl = false;
        this.dtk = 2;
        this.dtm = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.dss = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.dss).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.dss != null && (this.dss instanceof TextView)) {
            ((TextView) this.dss).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.dss != null) {
            ((SendView) this.dss).setTextColor(i);
        }
    }
}
