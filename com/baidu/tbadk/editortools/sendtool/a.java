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
        this.aCK = false;
        this.aCJ = 2;
        this.aCL = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aBT = new SendView(context);
        p.a aVar = new p.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aBT).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aBT != null && (this.aBT instanceof TextView)) {
            ((TextView) this.aBT).setText(i);
        }
    }
}
