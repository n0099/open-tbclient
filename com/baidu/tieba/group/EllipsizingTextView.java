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
    private final List<a> dAm;
    private boolean dAn;
    private boolean dAo;
    private boolean dAp;
    private String dAq;
    private float dAr;
    private float dAs;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gm(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dAm = new ArrayList();
        this.maxLines = -1;
        this.dAr = 1.0f;
        this.dAs = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAm = new ArrayList();
        this.maxLines = -1;
        this.dAr = 1.0f;
        this.dAs = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAm = new ArrayList();
        this.maxLines = -1;
        this.dAr = 1.0f;
        this.dAs = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dAm.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dAo = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dAs = f;
        this.dAr = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dAp) {
            this.dAq = charSequence.toString();
            this.dAo = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dAo) {
            super.setEllipsize(null);
            awK();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void awK() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dAq;
        if (maxLines != -1) {
            Layout mF = mF(str);
            if (mF.getLineCount() > maxLines) {
                String trim = this.dAq.substring(0, mF.getLineEnd(maxLines - 1)).trim();
                while (mF(trim + "...").getLineCount() > maxLines) {
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
                    this.dAp = true;
                    try {
                        setText(str);
                    } finally {
                        this.dAp = false;
                    }
                }
                this.dAo = false;
                if (z == this.dAn) {
                    this.dAn = z;
                    for (a aVar : this.dAm) {
                        aVar.gm(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dAo = false;
        if (z == this.dAn) {
        }
    }

    private Layout mF(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dAr, this.dAs, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
