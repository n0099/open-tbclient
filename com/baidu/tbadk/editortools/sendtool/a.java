package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 4);
        this.auE = false;
        this.auD = 2;
        this.auF = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 39, 9, 40};
        this.atI = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(r.e.ds100), context.getResources().getDimensionPixelSize(r.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        ((View) this.atI).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.atI != null && (this.atI instanceof TextView)) {
            ((TextView) this.atI).setText(i);
        }
    }

    public void setType(int i) {
        if (this.atI != null) {
            ((SendView) this.atI).setType(i);
        }
    }

    public void eJ(int i) {
        if (this.atI != null) {
            ((SendView) this.atI).eJ(i);
        }
    }
}
