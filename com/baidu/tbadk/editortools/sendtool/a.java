package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 4);
        this.aqp = false;
        this.aqo = 2;
        this.aqq = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 39, 9, 40};
        this.aps = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(t.e.ds100), context.getResources().getDimensionPixelSize(t.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        ((View) this.aps).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aps != null && (this.aps instanceof TextView)) {
            ((TextView) this.aps).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aps != null) {
            ((SendView) this.aps).setType(i);
        }
    }

    public void er(int i) {
        if (this.aps != null) {
            ((SendView) this.aps).er(i);
        }
    }
}
