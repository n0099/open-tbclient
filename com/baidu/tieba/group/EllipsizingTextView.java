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
    private float btf;
    private final List<a> eoV;
    private boolean eoW;
    private boolean eoX;
    private boolean eoY;
    private String eoZ;
    private float epa;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hG(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.eoV = new ArrayList();
        this.maxLines = -1;
        this.btf = 1.0f;
        this.epa = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoV = new ArrayList();
        this.maxLines = -1;
        this.btf = 1.0f;
        this.epa = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eoV = new ArrayList();
        this.maxLines = -1;
        this.btf = 1.0f;
        this.epa = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.eoV.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.eoX = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.epa = f;
        this.btf = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.eoY) {
            this.eoZ = charSequence.toString();
            this.eoX = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eoX) {
            super.setEllipsize(null);
            aJI();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aJI() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.eoZ;
        if (maxLines != -1) {
            Layout pd = pd(str);
            if (pd.getLineCount() > maxLines) {
                String trim = this.eoZ.substring(0, pd.getLineEnd(maxLines - 1)).trim();
                while (pd(trim + "...").getLineCount() > maxLines) {
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
                    this.eoY = true;
                    try {
                        setText(str);
                    } finally {
                        this.eoY = false;
                    }
                }
                this.eoX = false;
                if (z == this.eoW) {
                    this.eoW = z;
                    for (a aVar : this.eoV) {
                        aVar.hG(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.eoX = false;
        if (z == this.eoW) {
        }
    }

    private Layout pd(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.btf, this.epa, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
