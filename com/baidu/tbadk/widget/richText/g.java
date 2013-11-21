package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class g extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private Context f988a;
    private int b;
    private String c;
    private String d;

    public g(Context context, int i, String str) {
        this.f988a = null;
        this.b = 0;
        this.c = null;
        this.f988a = context;
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
        i iVar = null;
        if (this.f988a instanceof i) {
            iVar = (i) this.f988a;
        }
        if (iVar != null) {
            switch (this.b) {
                case 2:
                    iVar.b(this.f988a, this.c);
                    return;
                case 16:
                    iVar.a(this.f988a, this.c);
                    return;
                case 32:
                    iVar.c(this.f988a, this.c);
                    return;
                case 64:
                    iVar.d(this.f988a, this.c);
                    return;
                case DERTags.TAGGED /* 128 */:
                    iVar.e(this.f988a, this.c);
                    return;
                case 256:
                    iVar.a(this.f988a, this.c, this.d);
                    return;
                default:
                    return;
            }
        }
    }
}
