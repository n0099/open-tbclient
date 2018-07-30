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
    private final List<a> dRA;
    private boolean dRB;
    private boolean dRC;
    private boolean dRD;
    private String dRE;
    private float dRF;
    private float dRG;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gE(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dRA = new ArrayList();
        this.maxLines = -1;
        this.dRF = 1.0f;
        this.dRG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRA = new ArrayList();
        this.maxLines = -1;
        this.dRF = 1.0f;
        this.dRG = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRA = new ArrayList();
        this.maxLines = -1;
        this.dRF = 1.0f;
        this.dRG = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dRA.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dRC = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dRG = f;
        this.dRF = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dRD) {
            this.dRE = charSequence.toString();
            this.dRC = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dRC) {
            super.setEllipsize(null);
            aCR();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aCR() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dRE;
        if (maxLines != -1) {
            Layout np = np(str);
            if (np.getLineCount() > maxLines) {
                String trim = this.dRE.substring(0, np.getLineEnd(maxLines - 1)).trim();
                while (np(trim + "...").getLineCount() > maxLines) {
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
                    this.dRD = true;
                    try {
                        setText(str);
                    } finally {
                        this.dRD = false;
                    }
                }
                this.dRC = false;
                if (z == this.dRB) {
                    this.dRB = z;
                    for (a aVar : this.dRA) {
                        aVar.gE(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dRC = false;
        if (z == this.dRB) {
        }
    }

    private Layout np(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dRF, this.dRG, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
