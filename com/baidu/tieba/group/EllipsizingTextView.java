package com.baidu.tieba.group;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EllipsizingTextView extends TextView {
    private float btY;
    private final List<a> est;
    private boolean esu;
    private boolean esv;
    private boolean esw;
    private String esx;
    private float esy;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hJ(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.est = new ArrayList();
        this.maxLines = -1;
        this.btY = 1.0f;
        this.esy = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.est = new ArrayList();
        this.maxLines = -1;
        this.btY = 1.0f;
        this.esy = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.est = new ArrayList();
        this.maxLines = -1;
        this.btY = 1.0f;
        this.esy = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.est.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.esv = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.esy = f;
        this.btY = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.esw) {
            this.esx = charSequence.toString();
            this.esv = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.esv) {
            super.setEllipsize(null);
            aKV();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aKV() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.esx;
        if (maxLines != -1) {
            Layout pw = pw(str);
            if (pw.getLineCount() > maxLines) {
                String trim = this.esx.substring(0, pw.getLineEnd(maxLines - 1)).trim();
                while (pw(trim + "...").getLineCount() > maxLines) {
                    if (trim.length() > "...".length()) {
                        trim = trim.substring(0, trim.length() - "...".length());
                    }
                    int lastIndexOf = trim.lastIndexOf(32);
                    if (lastIndexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf);
                }
                str = trim + "...";
                z = true;
                if (!str.equals(getText())) {
                    this.esw = true;
                    try {
                        setText(str);
                    } finally {
                        this.esw = false;
                    }
                }
                this.esv = false;
                if (z == this.esu) {
                    this.esu = z;
                    for (a aVar : this.est) {
                        aVar.hJ(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.esv = false;
        if (z == this.esu) {
        }
    }

    private Layout pw(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.btY, this.esy, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
