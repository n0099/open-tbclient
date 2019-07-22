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
    private float cOP;
    private final List<a> gaB;
    private boolean gaC;
    private boolean gaD;
    private boolean gaE;
    private String gaF;
    private float gaG;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void ld(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.gaB = new ArrayList();
        this.maxLines = -1;
        this.cOP = 1.0f;
        this.gaG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gaB = new ArrayList();
        this.maxLines = -1;
        this.cOP = 1.0f;
        this.gaG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gaB = new ArrayList();
        this.maxLines = -1;
        this.cOP = 1.0f;
        this.gaG = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.gaB.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.gaD = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.gaG = f;
        this.cOP = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.gaE) {
            this.gaF = charSequence.toString();
            this.gaD = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gaD) {
            super.setEllipsize(null);
            bux();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bux() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.gaF;
        if (maxLines != -1) {
            Layout xT = xT(str);
            if (xT.getLineCount() > maxLines) {
                String trim = this.gaF.substring(0, xT.getLineEnd(maxLines - 1)).trim();
                while (xT(trim + "...").getLineCount() > maxLines) {
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
                    this.gaE = true;
                    try {
                        setText(str);
                    } finally {
                        this.gaE = false;
                    }
                }
                this.gaD = false;
                if (z == this.gaC) {
                    this.gaC = z;
                    for (a aVar : this.gaB) {
                        aVar.ld(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.gaD = false;
        if (z == this.gaC) {
        }
    }

    private Layout xT(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cOP, this.gaG, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
