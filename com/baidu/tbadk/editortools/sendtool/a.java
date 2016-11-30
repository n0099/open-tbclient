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
        this.avy = false;
        this.avx = 2;
        this.avz = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.auC = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(r.e.ds100), context.getResources().getDimensionPixelSize(r.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        ((View) this.auC).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.auC != null && (this.auC instanceof TextView)) {
            ((TextView) this.auC).setText(i);
        }
    }

    public void setType(int i) {
        if (this.auC != null) {
            ((SendView) this.auC).setType(i);
        }
    }

    public void eM(int i) {
        if (this.auC != null) {
            ((SendView) this.auC).eM(i);
        }
    }
}
