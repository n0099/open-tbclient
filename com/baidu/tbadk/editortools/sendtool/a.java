package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.v;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends x {
    public a(Context context) {
        super(context, (String) null, 4);
        this.auV = false;
        this.auU = 2;
        this.auW = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.auh = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(r.e.ds100), context.getResources().getDimensionPixelSize(r.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.e.ds10);
        ((View) this.auh).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.auh != null && (this.auh instanceof TextView)) {
            ((TextView) this.auh).setText(i);
        }
    }

    public void setType(int i) {
        if (this.auh != null) {
            ((SendView) this.auh).setType(i);
        }
    }

    public void eN(int i) {
        if (this.auh != null) {
            ((SendView) this.auh).eN(i);
        }
    }
}
