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
        this.arf = false;
        this.are = 2;
        this.arg = new int[]{4, 12, 10, 22, 23, 13, 11, 28, 29, 39, 9, 40};
        this.aqi = new SendView(context);
        y.a aVar = new y.a(context.getResources().getDimensionPixelSize(u.e.ds100), context.getResources().getDimensionPixelSize(u.e.ds78));
        aVar.gravity = 16;
        aVar.leftMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        aVar.rightMargin = context.getResources().getDimensionPixelSize(u.e.ds10);
        ((View) this.aqi).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aqi != null && (this.aqi instanceof TextView)) {
            ((TextView) this.aqi).setText(i);
        }
    }

    public void setType(int i) {
        if (this.aqi != null) {
            ((SendView) this.aqi).setType(i);
        }
    }

    public void ew(int i) {
        if (this.aqi != null) {
            ((SendView) this.aqi).ew(i);
        }
    }
}
