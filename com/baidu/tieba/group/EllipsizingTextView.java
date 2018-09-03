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
    private float dRA;
    private float dRB;
    private final List<a> dRv;
    private boolean dRw;
    private boolean dRx;
    private boolean dRy;
    private String dRz;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gE(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dRv = new ArrayList();
        this.maxLines = -1;
        this.dRA = 1.0f;
        this.dRB = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dRv = new ArrayList();
        this.maxLines = -1;
        this.dRA = 1.0f;
        this.dRB = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRv = new ArrayList();
        this.maxLines = -1;
        this.dRA = 1.0f;
        this.dRB = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dRv.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dRx = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dRB = f;
        this.dRA = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dRy) {
            this.dRz = charSequence.toString();
            this.dRx = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dRx) {
            super.setEllipsize(null);
            aCO();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aCO() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dRz;
        if (maxLines != -1) {
            Layout nr = nr(str);
            if (nr.getLineCount() > maxLines) {
                String trim = this.dRz.substring(0, nr.getLineEnd(maxLines - 1)).trim();
                while (nr(trim + "...").getLineCount() > maxLines) {
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
                    this.dRy = true;
                    try {
                        setText(str);
                    } finally {
                        this.dRy = false;
                    }
                }
                this.dRx = false;
                if (z == this.dRw) {
                    this.dRw = z;
                    for (a aVar : this.dRv) {
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
        this.dRx = false;
        if (z == this.dRw) {
        }
    }

    private Layout nr(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dRA, this.dRB, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
