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
    private boolean eeA;
    private boolean eeB;
    private String eeC;
    private float eeD;
    private float eeE;
    private final List<a> eey;
    private boolean eez;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gG(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.eey = new ArrayList();
        this.maxLines = -1;
        this.eeD = 1.0f;
        this.eeE = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eey = new ArrayList();
        this.maxLines = -1;
        this.eeD = 1.0f;
        this.eeE = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eey = new ArrayList();
        this.maxLines = -1;
        this.eeD = 1.0f;
        this.eeE = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.eey.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.eeA = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.eeE = f;
        this.eeD = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.eeB) {
            this.eeC = charSequence.toString();
            this.eeA = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eeA) {
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
        String str = this.eeC;
        if (maxLines != -1) {
            Layout mz = mz(str);
            if (mz.getLineCount() > maxLines) {
                String trim = this.eeC.substring(0, mz.getLineEnd(maxLines - 1)).trim();
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
                    this.eeB = true;
                    try {
                        setText(str);
                    } finally {
                        this.eeB = false;
                    }
                }
                this.eeA = false;
                if (z == this.eez) {
                    this.eez = z;
                    for (a aVar : this.eey) {
                        aVar.gG(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.eeA = false;
        if (z == this.eez) {
        }
    }

    private Layout mz(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.eeD, this.eeE, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
