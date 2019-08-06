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
        this.csS = false;
        this.csR = 2;
        this.csT = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.csa = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.csa).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.csa != null && (this.csa instanceof TextView)) {
            ((TextView) this.csa).setText(i);
        }
    }
}
