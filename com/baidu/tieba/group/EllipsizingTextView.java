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
    private float cFg;
    private final List<a> fEQ;
    private boolean fER;
    private boolean fES;
    private boolean fET;
    private String fEU;
    private float fEV;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kd(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.fEQ = new ArrayList();
        this.maxLines = -1;
        this.cFg = 1.0f;
        this.fEV = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEQ = new ArrayList();
        this.maxLines = -1;
        this.cFg = 1.0f;
        this.fEV = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEQ = new ArrayList();
        this.maxLines = -1;
        this.cFg = 1.0f;
        this.fEV = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.fEQ.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.fES = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.fEV = f;
        this.cFg = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.fET) {
            this.fEU = charSequence.toString();
            this.fES = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fES) {
            super.setEllipsize(null);
            blc();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void blc() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.fEU;
        if (maxLines != -1) {
            Layout vY = vY(str);
            if (vY.getLineCount() > maxLines) {
                String trim = this.fEU.substring(0, vY.getLineEnd(maxLines - 1)).trim();
                while (vY(trim + "...").getLineCount() > maxLines) {
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
                    this.fET = true;
                    try {
                        setText(str);
                    } finally {
                        this.fET = false;
                    }
                }
                this.fES = false;
                if (z == this.fER) {
                    this.fER = z;
                    for (a aVar : this.fEQ) {
                        aVar.kd(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.fES = false;
        if (z == this.fER) {
        }
    }

    private Layout vY(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cFg, this.fEV, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
