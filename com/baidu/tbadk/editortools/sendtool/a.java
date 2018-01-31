package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.p;
import com.baidu.tbadk.editortools.r;
/* loaded from: classes.dex */
public class a extends r {
    public a(Context context) {
        super(context, (String) null, 4);
        this.bra = false;
        this.bqZ = 2;
        this.brb = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.bqj = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.bqj).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.bqj != null && (this.bqj instanceof TextView)) {
            ((TextView) this.bqj).setText(i);
        }
    }
}
