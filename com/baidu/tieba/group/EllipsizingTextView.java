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
/* loaded from: classes5.dex */
public class EllipsizingTextView extends TextView {
    private float cNt;
    private final List<a> fVE;
    private boolean fVF;
    private boolean fVG;
    private boolean fVH;
    private String fVI;
    private float fVJ;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kT(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.fVE = new ArrayList();
        this.maxLines = -1;
        this.cNt = 1.0f;
        this.fVJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVE = new ArrayList();
        this.maxLines = -1;
        this.cNt = 1.0f;
        this.fVJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVE = new ArrayList();
        this.maxLines = -1;
        this.cNt = 1.0f;
        this.fVJ = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.fVE.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.fVG = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.fVJ = f;
        this.cNt = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.fVH) {
            this.fVI = charSequence.toString();
            this.fVG = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fVG) {
            super.setEllipsize(null);
            bsw();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bsw() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.fVI;
        if (maxLines != -1) {
            Layout xo = xo(str);
            if (xo.getLineCount() > maxLines) {
                String trim = this.fVI.substring(0, xo.getLineEnd(maxLines - 1)).trim();
                while (xo(trim + "...").getLineCount() > maxLines) {
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
                    this.fVH = true;
                    try {
                        setText(str);
                    } finally {
                        this.fVH = false;
                    }
                }
                this.fVG = false;
                if (z == this.fVF) {
                    this.fVF = z;
                    for (a aVar : this.fVE) {
                        aVar.kT(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.fVG = false;
        if (z == this.fVF) {
        }
    }

    private Layout xo(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cNt, this.fVJ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
