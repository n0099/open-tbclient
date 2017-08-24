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
        this.aCT = false;
        this.aCS = 2;
        this.aCU = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.aCe = new SendView(context);
        p.a aVar = new p.a(context.getResources().getDimensionPixelSize(d.f.ds100), context.getResources().getDimensionPixelSize(d.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(d.f.ds10);
        ((View) this.aCe).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aCe != null && (this.aCe instanceof TextView)) {
            ((TextView) this.aCe).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aCe != null) {
            ((SendView) this.aCe).setType(i);
        }
    }

    public void eP(int i) {
        if (this.aCe != null) {
            ((SendView) this.aCe).eP(i);
        }
    }
}
