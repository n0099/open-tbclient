package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.u;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends w {
    public a(Context context) {
        super(context, (String) null, 4);
        this.toolNeedAction = false;
        this.toolPosition = 2;
        this.toolLaunchAction = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 9};
        this.toolView = new SendView(context);
        u.a aVar = new u.a(context.getResources().getDimensionPixelSize(i.d.ds100), context.getResources().getDimensionPixelSize(i.d.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
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

    public void ef(int i) {
        if (this.toolView != null) {
            ((SendView) this.toolView).ef(i);
        }
    }
}
