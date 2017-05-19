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
        this.azL = false;
        this.azK = 2;
        this.azM = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.ayX = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(w.f.ds100), context.getResources().getDimensionPixelSize(w.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        ((View) this.ayX).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.ayX != null && (this.ayX instanceof TextView)) {
            ((TextView) this.ayX).setText(i);
        }
    }

    public void setType(int i) {
        if (this.ayX != null) {
            ((SendView) this.ayX).setType(i);
        }
    }

    public void eI(int i) {
        if (this.ayX != null) {
            ((SendView) this.ayX).eI(i);
        }
    }
}
