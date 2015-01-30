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
    private final List<i> TT;
    private boolean TU;
    private boolean TV;
    private boolean TW;
    private String TX;
    private float TY;
    private float TZ;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.TT = new ArrayList();
        this.maxLines = -1;
        this.TY = 1.0f;
        this.TZ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TT = new ArrayList();
        this.maxLines = -1;
        this.TY = 1.0f;
        this.TZ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TT = new ArrayList();
        this.maxLines = -1;
        this.TY = 1.0f;
        this.TZ = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.TT.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.TV = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.TZ = f;
        this.TY = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.TW) {
            this.TX = charSequence.toString();
            this.TV = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.TV) {
            super.setEllipsize(null);
            tG();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void tG() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.TX;
        if (maxLines != -1) {
            Layout dE = dE(str);
            if (dE.getLineCount() > maxLines) {
                String trim = this.TX.substring(0, dE.getLineEnd(maxLines - 1)).trim();
                while (dE(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.TW = true;
                    try {
                        setText(str);
                    } finally {
                        this.TW = false;
                    }
                }
                this.TV = false;
                if (z == this.TU) {
                    this.TU = z;
                    for (i iVar : this.TT) {
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
        this.TV = false;
        if (z == this.TU) {
        }
    }

    private Layout dE(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.TY, this.TZ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
