package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 4);
        this.cFX = false;
        this.cFW = 2;
        this.cFY = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.cFe = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.cFe).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.cFe != null && (this.cFe instanceof TextView)) {
            ((TextView) this.cFe).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.cFe != null) {
            ((SendView) this.cFe).setTextColor(i);
        }
    }
}
