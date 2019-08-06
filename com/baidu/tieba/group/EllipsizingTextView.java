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
    private float cOW;
    private final List<a> gbr;
    private boolean gbs;
    private boolean gbt;
    private boolean gbu;
    private String gbv;
    private float gbw;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void ld(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.gbr = new ArrayList();
        this.maxLines = -1;
        this.cOW = 1.0f;
        this.gbw = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbr = new ArrayList();
        this.maxLines = -1;
        this.cOW = 1.0f;
        this.gbw = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbr = new ArrayList();
        this.maxLines = -1;
        this.cOW = 1.0f;
        this.gbw = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.gbr.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.gbt = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.gbw = f;
        this.cOW = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.gbu) {
            this.gbv = charSequence.toString();
            this.gbt = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gbt) {
            super.setEllipsize(null);
            buK();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void buK() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.gbv;
        if (maxLines != -1) {
            Layout xU = xU(str);
            if (xU.getLineCount() > maxLines) {
                String trim = this.gbv.substring(0, xU.getLineEnd(maxLines - 1)).trim();
                while (xU(trim + "...").getLineCount() > maxLines) {
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
                    this.gbu = true;
                    try {
                        setText(str);
                    } finally {
                        this.gbu = false;
                    }
                }
                this.gbt = false;
                if (z == this.gbs) {
                    this.gbs = z;
                    for (a aVar : this.gbr) {
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
        this.gbt = false;
        if (z == this.gbs) {
        }
    }

    private Layout xU(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cOW, this.gbw, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
