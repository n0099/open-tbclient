package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.k;
/* loaded from: classes.dex */
public class a extends k {
    public a(Context context) {
        super(context, (String) null, 4);
        this.cry = false;
        this.crx = 2;
        this.crz = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.cqF = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.cqF).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.cqF != null && (this.cqF instanceof TextView)) {
            ((TextView) this.cqF).setText(i);
        }
    }
}
