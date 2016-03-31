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
        this.toolNeedAction = false;
        this.toolPosition = 2;
        this.toolLaunchAction = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 39, 9, 40};
        this.toolView = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(t.e.ds100), context.getResources().getDimensionPixelSize(t.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(t.e.ds10);
        ((View) this.toolView).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.toolView != null && (this.toolView instanceof TextView)) {
            ((TextView) this.toolView).setText(i);
        }
    }

    public void setType(int i) {
        if (this.toolView != null) {
            ((SendView) this.toolView).setType(i);
        }
    }

    public void eM(int i) {
        if (this.toolView != null) {
            ((SendView) this.toolView).eM(i);
        }
    }
}
