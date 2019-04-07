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
        this.cjo = false;
        this.cjn = 2;
        this.cjp = new int[]{4, 12, 10, 13, 11, 28, 29, 39, 9};
        this.ciw = new SendView(context);
        RawLayout.a aVar = new RawLayout.a(-2, -2);
        aVar.gravity = 80;
        ((View) this.ciw).setLayoutParams(aVar);
    }

    public void setText(int i) {
        if (this.ciw != null && (this.ciw instanceof TextView)) {
            ((TextView) this.ciw).setText(i);
        }
    }
}
