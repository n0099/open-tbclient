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
    private final List<a> dON;
    private boolean dOO;
    private boolean dOP;
    private boolean dOQ;
    private String dOR;
    private float dOS;
    private float dOT;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gC(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dON = new ArrayList();
        this.maxLines = -1;
        this.dOS = 1.0f;
        this.dOT = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dON = new ArrayList();
        this.maxLines = -1;
        this.dOS = 1.0f;
        this.dOT = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dON = new ArrayList();
        this.maxLines = -1;
        this.dOS = 1.0f;
        this.dOT = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dON.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dOP = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dOT = f;
        this.dOS = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dOQ) {
            this.dOR = charSequence.toString();
            this.dOP = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dOP) {
            super.setEllipsize(null);
            aCi();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aCi() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dOR;
        if (maxLines != -1) {
            Layout nr = nr(str);
            if (nr.getLineCount() > maxLines) {
                String trim = this.dOR.substring(0, nr.getLineEnd(maxLines - 1)).trim();
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
                    this.dOQ = true;
                    try {
                        setText(str);
                    } finally {
                        this.dOQ = false;
                    }
                }
                this.dOP = false;
                if (z == this.dOO) {
                    this.dOO = z;
                    for (a aVar : this.dON) {
                        aVar.gC(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dOP = false;
        if (z == this.dOO) {
        }
    }

    private Layout nr(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dOS, this.dOT, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
