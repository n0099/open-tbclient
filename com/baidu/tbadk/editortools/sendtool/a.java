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
        this.aZc = false;
        this.aZb = 2;
        this.aZd = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aYl = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aYl).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aYl != null && (this.aYl instanceof TextView)) {
            ((TextView) this.aYl).setText(i);
        }
    }
}
