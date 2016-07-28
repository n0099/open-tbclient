package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.aa;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends aa {
    public a(Context context) {
        super(context, (String) null, 4);
        this.arU = false;
        this.arT = 2;
        this.arV = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 39, 9, 40};
        this.aqX = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(u.e.ds100), context.getResources().getDimensionPixelSize(u.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        ((View) this.aqX).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aqX != null && (this.aqX instanceof TextView)) {
            ((TextView) this.aqX).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aqX != null) {
            ((SendView) this.aqX).setType(i);
        }
    }

    public void ew(int i) {
        if (this.aqX != null) {
            ((SendView) this.aqX).ew(i);
        }
    }
}
