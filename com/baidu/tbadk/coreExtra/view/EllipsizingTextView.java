package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class EllipsizingTextView extends TextView {
    private final List<a> akD;
    private boolean akE;
    private boolean akF;
    private boolean akG;
    private String akH;
    private float akI;
    private float akJ;
    private int maxLines;

    /* loaded from: classes.dex */
    public interface a {
        void aR(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.akD = new ArrayList();
        this.maxLines = -1;
        this.akI = 1.0f;
        this.akJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akD = new ArrayList();
        this.maxLines = -1;
        this.akI = 1.0f;
        this.akJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akD = new ArrayList();
        this.maxLines = -1;
        this.akI = 1.0f;
        this.akJ = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.akD.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.akF = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.akJ = f;
        this.akI = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.akG) {
            this.akH = charSequence.toString();
            this.akF = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.akF) {
            super.setEllipsize(null);
            zc();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zc() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.akH;
        if (maxLines != -1) {
            Layout en = en(str);
            if (en.getLineCount() > maxLines) {
                String trim = this.akH.substring(0, en.getLineEnd(maxLines - 1)).trim();
                while (en(String.valueOf(trim) + "...").getLineCount() > maxLines) {
                    if (trim.length() > "...".length()) {
                        trim = trim.substring(0, trim.length() - "...".length());
                    }
                    int lastIndexOf = trim.lastIndexOf(32);
                    if (lastIndexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf);
                }
                str = String.valueOf(trim) + "...";
                z = true;
                if (!str.equals(getText())) {
                    this.akG = true;
                    try {
                        setText(str);
                    } finally {
                        this.akG = false;
                    }
                }
                this.akF = false;
                if (z == this.akE) {
                    this.akE = z;
                    for (a aVar : this.akD) {
                        aVar.aR(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.akF = false;
        if (z == this.akE) {
        }
    }

    private Layout en(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.akI, this.akJ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
