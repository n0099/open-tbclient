package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class f extends ClickableSpan {
    private Context a;
    private int b;
    private String c;

    public f(Context context, int i, String str) {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.a = context;
        this.c = str;
        this.b = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        h hVar = null;
        if (this.a instanceof h) {
            hVar = (h) this.a;
        }
        if (hVar != null) {
            switch (this.b) {
                case 2:
                    hVar.b(this.a, this.c);
                    return;
                case 16:
                    hVar.a(this.a, this.c);
                    return;
                case 32:
                    hVar.c(this.a, this.c);
                    return;
                case DERTags.APPLICATION /* 64 */:
                    hVar.d(this.a, this.c);
                    return;
                default:
                    return;
            }
        }
    }
}
