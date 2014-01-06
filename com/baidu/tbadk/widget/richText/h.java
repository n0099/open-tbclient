package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class h extends ClickableSpan {
    private Context a;
    private int b;
    private String c;
    private String d;

    public h(Context context, int i, String str) {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.a = context;
        this.c = str;
        this.b = i;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        j jVar = null;
        if (this.a instanceof j) {
            jVar = (j) this.a;
        }
        if (jVar != null) {
            switch (this.b) {
                case 2:
                    jVar.b(this.a, this.c);
                    return;
                case 16:
                    jVar.a(this.a, this.c);
                    return;
                case 32:
                    jVar.c(this.a, this.c);
                    return;
                case DERTags.APPLICATION /* 64 */:
                    jVar.d(this.a, this.c);
                    return;
                case DERTags.TAGGED /* 128 */:
                    jVar.e(this.a, this.c);
                    return;
                case 256:
                    jVar.a(this.a, this.c, this.d);
                    return;
                default:
                    return;
            }
        }
    }
}
