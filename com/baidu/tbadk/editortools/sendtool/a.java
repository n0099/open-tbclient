package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context) {
        super(context, (String) null, 4);
        this.aBx = false;
        this.aBw = 2;
        this.aBy = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aAH = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aAH).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aAH != null && (this.aAH instanceof TextView)) {
            ((TextView) this.aAH).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aAH != null) {
            ((SendView) this.aAH).setType(i);
        }
    }

    public void fa(int i) {
        if (this.aAH != null) {
            ((SendView) this.aAH).fa(i);
        }
    }
}
