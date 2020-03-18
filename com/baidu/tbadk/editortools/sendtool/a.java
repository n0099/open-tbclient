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
        this.dxS = false;
        this.dxR = 2;
        this.dxT = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.dxa = new SendView(context);
        RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 80;
        ((View) this.dxa).setLayoutParams(layoutParams);
    }

    public void setText(int i) {
        if (this.dxa != null && (this.dxa instanceof TextView)) {
            ((TextView) this.dxa).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.dxa != null) {
            ((SendView) this.dxa).setTextColor(i);
        }
    }
}
