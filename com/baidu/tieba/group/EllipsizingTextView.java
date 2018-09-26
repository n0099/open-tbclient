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
    private float bkU;
    private final List<a> dYN;
    private boolean dYO;
    private boolean dYP;
    private boolean dYQ;
    private String dYR;
    private float dYS;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hc(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dYN = new ArrayList();
        this.maxLines = -1;
        this.bkU = 1.0f;
        this.dYS = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYN = new ArrayList();
        this.maxLines = -1;
        this.bkU = 1.0f;
        this.dYS = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYN = new ArrayList();
        this.maxLines = -1;
        this.bkU = 1.0f;
        this.dYS = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dYN.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dYP = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dYS = f;
        this.bkU = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dYQ) {
            this.dYR = charSequence.toString();
            this.dYP = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dYP) {
            super.setEllipsize(null);
            aFb();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aFb() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dYR;
        if (maxLines != -1) {
            Layout nW = nW(str);
            if (nW.getLineCount() > maxLines) {
                String trim = this.dYR.substring(0, nW.getLineEnd(maxLines - 1)).trim();
                while (nW(trim + "...").getLineCount() > maxLines) {
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
                    this.dYQ = true;
                    try {
                        setText(str);
                    } finally {
                        this.dYQ = false;
                    }
                }
                this.dYP = false;
                if (z == this.dYO) {
                    this.dYO = z;
                    for (a aVar : this.dYN) {
                        aVar.hc(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dYP = false;
        if (z == this.dYO) {
        }
    }

    private Layout nW(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.bkU, this.dYS, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
