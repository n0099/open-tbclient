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
        this.aBU = false;
        this.aBT = 2;
        this.aBV = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aBf = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aBf).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aBf != null && (this.aBf instanceof TextView)) {
            ((TextView) this.aBf).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aBf != null) {
            ((SendView) this.aBf).setType(i);
        }
    }

    public void fa(int i) {
        if (this.aBf != null) {
            ((SendView) this.aBf).fa(i);
        }
    }
}
