package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public class h extends ClickableSpan {
    private String abJ;
    private Context mContext;
    private int mType;
    private String mUrl;

    public h(Context context, int i, String str) {
        this.mContext = null;
        this.mType = 0;
        this.mUrl = null;
        this.mContext = context;
        this.mUrl = str;
        this.mType = i;
    }

    public void dR(String str) {
        this.abJ = str;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        j jVar = null;
        if (this.mContext instanceof j) {
            jVar = (j) this.mContext;
        }
        if (jVar != null) {
            switch (this.mType) {
                case 2:
                    jVar.t(this.mContext, this.mUrl);
                    return;
                case 16:
                    jVar.s(this.mContext, this.mUrl);
                    return;
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    jVar.u(this.mContext, this.mUrl);
                    return;
                case 64:
                    jVar.v(this.mContext, this.mUrl);
                    return;
                case 128:
                    jVar.w(this.mContext, this.mUrl);
                    return;
                case 256:
                    jVar.b(this.mContext, this.mUrl, this.abJ);
                    return;
                default:
                    return;
            }
        }
    }
}
