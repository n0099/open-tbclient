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
    private final List<a> eeC;
    private boolean eeD;
    private boolean eeE;
    private boolean eeF;
    private String eeG;
    private float eeH;
    private float eeI;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gL(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.eeC = new ArrayList();
        this.maxLines = -1;
        this.eeH = 1.0f;
        this.eeI = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eeC = new ArrayList();
        this.maxLines = -1;
        this.eeH = 1.0f;
        this.eeI = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eeC = new ArrayList();
        this.maxLines = -1;
        this.eeH = 1.0f;
        this.eeI = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.eeC.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.eeE = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.eeI = f;
        this.eeH = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.eeF) {
            this.eeG = charSequence.toString();
            this.eeE = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eeE) {
            super.setEllipsize(null);
            aBP();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aBP() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.eeG;
        if (maxLines != -1) {
            Layout mz = mz(str);
            if (mz.getLineCount() > maxLines) {
                String trim = this.eeG.substring(0, mz.getLineEnd(maxLines - 1)).trim();
                while (mz(trim + "...").getLineCount() > maxLines) {
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
                    this.eeF = true;
                    try {
                        setText(str);
                    } finally {
                        this.eeF = false;
                    }
                }
                this.eeE = false;
                if (z == this.eeD) {
                    this.eeD = z;
                    for (a aVar : this.eeC) {
                        aVar.gL(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.eeE = false;
        if (z == this.eeD) {
        }
    }

    private Layout mz(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.eeH, this.eeI, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
