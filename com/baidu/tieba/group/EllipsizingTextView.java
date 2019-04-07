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
    private float cFi;
    private final List<a> fEE;
    private boolean fEF;
    private boolean fEG;
    private boolean fEH;
    private String fEI;
    private float fEJ;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kd(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.fEE = new ArrayList();
        this.maxLines = -1;
        this.cFi = 1.0f;
        this.fEJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fEE = new ArrayList();
        this.maxLines = -1;
        this.cFi = 1.0f;
        this.fEJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEE = new ArrayList();
        this.maxLines = -1;
        this.cFi = 1.0f;
        this.fEJ = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.fEE.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.fEG = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.fEJ = f;
        this.cFi = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.fEH) {
            this.fEI = charSequence.toString();
            this.fEG = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fEG) {
            super.setEllipsize(null);
            bkZ();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bkZ() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.fEI;
        if (maxLines != -1) {
            Layout vX = vX(str);
            if (vX.getLineCount() > maxLines) {
                String trim = this.fEI.substring(0, vX.getLineEnd(maxLines - 1)).trim();
                while (vX(trim + "...").getLineCount() > maxLines) {
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
                    this.fEH = true;
                    try {
                        setText(str);
                    } finally {
                        this.fEH = false;
                    }
                }
                this.fEG = false;
                if (z == this.fEF) {
                    this.fEF = z;
                    for (a aVar : this.fEE) {
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
        this.fEG = false;
        if (z == this.fEF) {
        }
    }

    private Layout vX(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cFi, this.fEJ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
