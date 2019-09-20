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
        this.ctO = false;
        this.ctN = 2;
        this.ctP = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.csV = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.csV).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.csV != null && (this.csV instanceof TextView)) {
            ((TextView) this.csV).setText(i);
        }
    }

    public void setTextColor(@ColorRes int i) {
        if (this.csV != null) {
            ((SendView) this.csV).setTextColor(i);
        }
    }
}
