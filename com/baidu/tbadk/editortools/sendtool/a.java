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
        this.aCg = false;
        this.aCf = 2;
        this.aCh = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.aBq = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aBq).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aBq != null && (this.aBq instanceof TextView)) {
            ((TextView) this.aBq).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aBq != null) {
            ((SendView) this.aBq).setType(i);
        }
    }

    public void eP(int i) {
        if (this.aBq != null) {
            ((SendView) this.aBq).eP(i);
        }
    }
}
