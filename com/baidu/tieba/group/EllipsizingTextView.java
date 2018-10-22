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
    private float boW;
    private final List<a> egH;
    private boolean egI;
    private boolean egJ;
    private boolean egK;
    private String egL;
    private float egM;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hu(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.egH = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egM = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egH = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egM = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egH = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egM = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.egH.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.egJ = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.egM = f;
        this.boW = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.egK) {
            this.egL = charSequence.toString();
            this.egJ = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.egJ) {
            super.setEllipsize(null);
            aIt();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aIt() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.egL;
        if (maxLines != -1) {
            Layout oA = oA(str);
            if (oA.getLineCount() > maxLines) {
                String trim = this.egL.substring(0, oA.getLineEnd(maxLines - 1)).trim();
                while (oA(trim + "...").getLineCount() > maxLines) {
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
                    this.egK = true;
                    try {
                        setText(str);
                    } finally {
                        this.egK = false;
                    }
                }
                this.egJ = false;
                if (z == this.egI) {
                    this.egI = z;
                    for (a aVar : this.egH) {
                        aVar.hu(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.egJ = false;
        if (z == this.egI) {
        }
    }

    private Layout oA(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.boW, this.egM, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
