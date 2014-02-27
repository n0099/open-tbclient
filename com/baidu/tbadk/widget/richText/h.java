package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public final class h extends ClickableSpan {
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

    public final void a(String str) {
        this.d = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        j jVar = null;
        if (this.a instanceof j) {
            jVar = (j) this.a;
        }
        if (jVar != null) {
            switch (this.b) {
                case 2:
                    jVar.a(this.a, this.c);
                    return;
                case 16:
                    Context context = this.a;
                    jVar.a(this.c);
                    return;
                case 32:
                    Context context2 = this.a;
                    jVar.b(this.c);
                    return;
                case AccessibilityNodeInfoCompat.ACTION_ACCESSIBILITY_FOCUS /* 64 */:
                    Context context3 = this.a;
                    String str = this.c;
                    return;
                case 128:
                    Context context4 = this.a;
                    jVar.c(this.c);
                    return;
                case 256:
                    Context context5 = this.a;
                    jVar.a(this.c, this.d);
                    return;
                default:
                    return;
            }
        }
    }
}
