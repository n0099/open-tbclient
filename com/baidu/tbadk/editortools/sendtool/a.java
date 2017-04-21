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
        this.azN = false;
        this.azM = 2;
        this.azO = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.ayZ = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(w.f.ds100), context.getResources().getDimensionPixelSize(w.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        ((View) this.ayZ).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.ayZ != null && (this.ayZ instanceof TextView)) {
            ((TextView) this.ayZ).setText(i);
        }
    }

    public void setType(int i) {
        if (this.ayZ != null) {
            ((SendView) this.ayZ).setType(i);
        }
    }

    public void eM(int i) {
        if (this.ayZ != null) {
            ((SendView) this.ayZ).eM(i);
        }
    }
}
