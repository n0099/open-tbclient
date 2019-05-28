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
    private final List<a> fVC;
    private boolean fVD;
    private boolean fVE;
    private boolean fVF;
    private String fVG;
    private float fVH;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kS(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.fVC = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVH = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fVC = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVH = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fVC = new ArrayList();
        this.maxLines = -1;
        this.cNs = 1.0f;
        this.fVH = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.fVC.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.fVE = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.fVH = f;
        this.cNs = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.fVF) {
            this.fVG = charSequence.toString();
            this.fVE = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.fVE) {
            super.setEllipsize(null);
            bsu();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bsu() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.fVG;
        if (maxLines != -1) {
            Layout xm = xm(str);
            if (xm.getLineCount() > maxLines) {
                String trim = this.fVG.substring(0, xm.getLineEnd(maxLines - 1)).trim();
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
                    this.fVF = true;
                    try {
                        setText(str);
                    } finally {
                        this.fVF = false;
                    }
                }
                this.fVE = false;
                if (z == this.fVD) {
                    this.fVD = z;
                    for (a aVar : this.fVC) {
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
        this.fVE = false;
        if (z == this.fVD) {
        }
    }

    private Layout xm(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cNs, this.fVH, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
