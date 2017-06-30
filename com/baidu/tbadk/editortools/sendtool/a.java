package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context) {
        super(context, (String) null, 4);
        this.aAA = false;
        this.aAz = 2;
        this.aAB = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.azL = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(w.f.ds100), context.getResources().getDimensionPixelSize(w.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        ((View) this.azL).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.azL != null && (this.azL instanceof TextView)) {
            ((TextView) this.azL).setText(i);
        }
    }

    public void setType(int i) {
        if (this.azL != null) {
            ((SendView) this.azL).setType(i);
        }
    }

    public void eL(int i) {
        if (this.azL != null) {
            ((SendView) this.azL).eL(i);
        }
    }
}
