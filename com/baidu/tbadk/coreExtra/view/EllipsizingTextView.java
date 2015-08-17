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
    private final List<a> akl;
    private boolean akm;
    private boolean akn;
    private boolean ako;
    private String akp;
    private float akq;
    private float akr;
    private int maxLines;

    /* loaded from: classes.dex */
    public interface a {
        void aQ(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.akl = new ArrayList();
        this.maxLines = -1;
        this.akq = 1.0f;
        this.akr = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akl = new ArrayList();
        this.maxLines = -1;
        this.akq = 1.0f;
        this.akr = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akl = new ArrayList();
        this.maxLines = -1;
        this.akq = 1.0f;
        this.akr = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.akl.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.akn = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.akr = f;
        this.akq = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.ako) {
            this.akp = charSequence.toString();
            this.akn = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.akn) {
            super.setEllipsize(null);
            yV();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void yV() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.akp;
        if (maxLines != -1) {
            Layout eg = eg(str);
            if (eg.getLineCount() > maxLines) {
                String trim = this.akp.substring(0, eg.getLineEnd(maxLines - 1)).trim();
                while (eg(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.ako = true;
                    try {
                        setText(str);
                    } finally {
                        this.ako = false;
                    }
                }
                this.akn = false;
                if (z == this.akm) {
                    this.akm = z;
                    for (a aVar : this.akl) {
                        aVar.aQ(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.akn = false;
        if (z == this.akm) {
        }
    }

    private Layout eg(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.akq, this.akr, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
