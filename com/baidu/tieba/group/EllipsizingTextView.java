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
    private final List<a> egG;
    private boolean egH;
    private boolean egI;
    private boolean egJ;
    private String egK;
    private float egL;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hu(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.egG = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egL = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egG = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egL = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egG = new ArrayList();
        this.maxLines = -1;
        this.boW = 1.0f;
        this.egL = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.egG.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.egI = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.egL = f;
        this.boW = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.egJ) {
            this.egK = charSequence.toString();
            this.egI = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.egI) {
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
        String str = this.egK;
        if (maxLines != -1) {
            Layout oA = oA(str);
            if (oA.getLineCount() > maxLines) {
                String trim = this.egK.substring(0, oA.getLineEnd(maxLines - 1)).trim();
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
                    this.egJ = true;
                    try {
                        setText(str);
                    } finally {
                        this.egJ = false;
                    }
                }
                this.egI = false;
                if (z == this.egH) {
                    this.egH = z;
                    for (a aVar : this.egG) {
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
        this.egI = false;
        if (z == this.egH) {
        }
    }

    private Layout oA(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.boW, this.egL, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
