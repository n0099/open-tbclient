package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.u;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a extends v {
    public a(Context context) {
        super(context, (String) null, 4);
        this.apj = false;
        this.api = 2;
        this.apk = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 9};
        this.aox = new SendView(context);
        u.a aVar = new u.a(context.getResources().getDimensionPixelSize(i.d.ds100), context.getResources().getDimensionPixelSize(i.d.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(i.d.ds10);
        ((View) this.aox).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aox != null && (this.aox instanceof TextView)) {
            ((TextView) this.aox).setText(i);
        }
    }
}
