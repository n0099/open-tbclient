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
        this.aMW = false;
        this.aMV = 2;
        this.aMX = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.aMf = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.aMf).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.aMf != null && (this.aMf instanceof TextView)) {
            ((TextView) this.aMf).setText(i);
        }
    }
}
