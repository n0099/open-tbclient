package com.baidu.tbadk.widget.richText;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public class h extends ClickableSpan {
    private String aka;
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

    public void eI(String str) {
        this.aka = str;
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
                    jVar.onLinkClicked(this.mContext, this.mUrl);
                    return;
                case 16:
                    jVar.onAtClicked(this.mContext, this.mUrl);
                    return;
                case 32:
                    jVar.onVideoClicked(this.mContext, this.mUrl);
                    return;
                case 64:
                    jVar.onSongClicked(this.mContext, this.mUrl);
                    return;
                case 128:
                    jVar.onVideoP2PClicked(this.mContext, this.mUrl);
                    return;
                case 256:
                    jVar.onPhoneClicked(this.mContext, this.mUrl, this.aka);
                    return;
                default:
                    return;
            }
        }
    }
}
