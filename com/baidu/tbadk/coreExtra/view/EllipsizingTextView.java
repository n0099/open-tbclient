package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EllipsizingTextView extends TextView {
    private final List<i> TQ;
    private boolean TR;
    private boolean TS;
    private boolean TT;
    private String TU;
    private float TV;
    private float TW;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.TQ = new ArrayList();
        this.maxLines = -1;
        this.TV = 1.0f;
        this.TW = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TQ = new ArrayList();
        this.maxLines = -1;
        this.TV = 1.0f;
        this.TW = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TQ = new ArrayList();
        this.maxLines = -1;
        this.TV = 1.0f;
        this.TW = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.TQ.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.TS = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.TW = f;
        this.TV = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.TT) {
            this.TU = charSequence.toString();
            this.TS = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.TS) {
            super.setEllipsize(null);
            tA();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void tA() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.TU;
        if (maxLines != -1) {
            Layout dB = dB(str);
            if (dB.getLineCount() > maxLines) {
                String trim = this.TU.substring(0, dB.getLineEnd(maxLines - 1)).trim();
                while (dB(String.valueOf(trim) + "...").getLineCount() > maxLines) {
                    if (trim.length() > "...".length()) {
                        trim = trim.substring(0, trim.length() - "...".length());
                    }
                    int lastIndexOf = trim.lastIndexOf(32);
                    if (lastIndexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf);
                }
                str = String.valueOf(trim) + "...";
                z = true;
                if (!str.equals(getText())) {
                    this.TT = true;
                    try {
                        setText(str);
                    } finally {
                        this.TT = false;
                    }
                }
                this.TS = false;
                if (z == this.TR) {
                    this.TR = z;
                    for (i iVar : this.TQ) {
                        iVar.aA(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.TS = false;
        if (z == this.TR) {
        }
    }

    private Layout dB(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.TV, this.TW, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
