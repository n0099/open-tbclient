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
        this.azx = false;
        this.azw = 2;
        this.azy = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.ayJ = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(w.f.ds100), context.getResources().getDimensionPixelSize(w.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(w.f.ds10);
        ((View) this.ayJ).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.ayJ != null && (this.ayJ instanceof TextView)) {
            ((TextView) this.ayJ).setText(i);
        }
    }

    public void setType(int i) {
        if (this.ayJ != null) {
            ((SendView) this.ayJ).setType(i);
        }
    }

    public void eJ(int i) {
        if (this.ayJ != null) {
            ((SendView) this.ayJ).eJ(i);
        }
    }
}
