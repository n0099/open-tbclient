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
    private String dLA;
    private float dLB;
    private float dLC;
    private final List<a> dLw;
    private boolean dLx;
    private boolean dLy;
    private boolean dLz;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gs(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dLw = new ArrayList();
        this.maxLines = -1;
        this.dLB = 1.0f;
        this.dLC = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLw = new ArrayList();
        this.maxLines = -1;
        this.dLB = 1.0f;
        this.dLC = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLw = new ArrayList();
        this.maxLines = -1;
        this.dLB = 1.0f;
        this.dLC = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dLw.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dLy = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dLC = f;
        this.dLB = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dLz) {
            this.dLA = charSequence.toString();
            this.dLy = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dLy) {
            super.setEllipsize(null);
            aBC();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aBC() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dLA;
        if (maxLines != -1) {
            Layout nq = nq(str);
            if (nq.getLineCount() > maxLines) {
                String trim = this.dLA.substring(0, nq.getLineEnd(maxLines - 1)).trim();
                while (nq(trim + "...").getLineCount() > maxLines) {
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
                    this.dLz = true;
                    try {
                        setText(str);
                    } finally {
                        this.dLz = false;
                    }
                }
                this.dLy = false;
                if (z == this.dLx) {
                    this.dLx = z;
                    for (a aVar : this.dLw) {
                        aVar.gs(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dLy = false;
        if (z == this.dLx) {
        }
    }

    private Layout nq(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dLB, this.dLC, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
