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
        this.aua = false;
        this.atZ = 2;
        this.aub = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9, 40};
        this.atm = new SendView(context);
        v.a aVar = new v.a(context.getResources().getDimensionPixelSize(r.f.ds100), context.getResources().getDimensionPixelSize(r.f.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(r.f.ds10);
        ((View) this.atm).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.atm != null && (this.atm instanceof TextView)) {
            ((TextView) this.atm).setText(i);
        }
    }

    public void setType(int i) {
        if (this.atm != null) {
            ((SendView) this.atm).setType(i);
        }
    }

    public void eO(int i) {
        if (this.atm != null) {
            ((SendView) this.atm).eO(i);
        }
    }
}
