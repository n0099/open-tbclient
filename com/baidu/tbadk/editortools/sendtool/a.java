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
        this.aBl = false;
        this.aBk = 2;
        this.aBm = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aAv = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aAv).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aAv != null && (this.aAv instanceof TextView)) {
            ((TextView) this.aAv).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aAv != null) {
            ((SendView) this.aAv).setType(i);
        }
    }

    public void eZ(int i) {
        if (this.aAv != null) {
            ((SendView) this.aAv).eZ(i);
        }
    }
}
