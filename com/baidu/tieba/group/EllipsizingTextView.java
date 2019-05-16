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
    private float cNs;
    private final List<a> fVB;
    private boolean fVC;
    private boolean fVD;
    private boolean fVE;
    private String fVF;
    private float fVG;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kS(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.fVB = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVB = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVB = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVG = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.fVB.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.fVD = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.fVG = f;
        this.cNs = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.fVE) {
            this.fVF = charSequence.toString();
            this.fVD = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fVD) {
            super.setEllipsize(null);
            bsr();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bsr() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.fVF;
        if (maxLines != -1) {
            Layout xm = xm(str);
            if (xm.getLineCount() > maxLines) {
                String trim = this.fVF.substring(0, xm.getLineEnd(maxLines - 1)).trim();
                while (xm(trim + "...").getLineCount() > maxLines) {
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
                    this.fVE = true;
                    try {
                        setText(str);
                    } finally {
                        this.fVE = false;
                    }
                }
                this.fVD = false;
                if (z == this.fVC) {
                    this.fVC = z;
                    for (a aVar : this.fVB) {
                        aVar.kS(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.fVD = false;
        if (z == this.fVC) {
        }
    }

    private Layout xm(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cNs, this.fVG, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
