package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context) {
        super(context, (String) null, 4);
        this.aCR = false;
        this.aCQ = 2;
        this.aCS = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.aCc = new SendView(context);
        p.a aVar = new p.a(context.getResources().getDimensionPixelSize(d.f.ds100), context.getResources().getDimensionPixelSize(d.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        ((View) this.aCc).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aCc != null && (this.aCc instanceof TextView)) {
            ((TextView) this.aCc).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aCc != null) {
            ((SendView) this.aCc).setType(i);
        }
    }

    public void eP(int i) {
        if (this.aCc != null) {
            ((SendView) this.aCc).eP(i);
        }
    }
}
