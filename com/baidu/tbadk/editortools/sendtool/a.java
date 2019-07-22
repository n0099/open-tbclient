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
        this.csL = false;
        this.csK = 2;
        this.csM = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.crT = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.crT).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.crT != null && (this.crT instanceof TextView)) {
            ((TextView) this.crT).setText(i);
        }
    }
}
