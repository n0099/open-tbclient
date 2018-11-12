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
    private float bpI;
    private final List<a> eib;
    private boolean eic;
    private boolean eid;
    private boolean eie;
    private String eif;
    private float eig;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hE(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.eib = new ArrayList();
        this.maxLines = -1;
        this.bpI = 1.0f;
        this.eig = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eib = new ArrayList();
        this.maxLines = -1;
        this.bpI = 1.0f;
        this.eig = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eib = new ArrayList();
        this.maxLines = -1;
        this.bpI = 1.0f;
        this.eig = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.eib.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.eid = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.eig = f;
        this.bpI = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.eie) {
            this.eif = charSequence.toString();
            this.eid = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.eid) {
            super.setEllipsize(null);
            aHR();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aHR() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.eif;
        if (maxLines != -1) {
            Layout oB = oB(str);
            if (oB.getLineCount() > maxLines) {
                String trim = this.eif.substring(0, oB.getLineEnd(maxLines - 1)).trim();
                while (oB(trim + "...").getLineCount() > maxLines) {
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
                    this.eie = true;
                    try {
                        setText(str);
                    } finally {
                        this.eie = false;
                    }
                }
                this.eid = false;
                if (z == this.eic) {
                    this.eic = z;
                    for (a aVar : this.eib) {
                        aVar.hE(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.eid = false;
        if (z == this.eic) {
        }
    }

    private Layout oB(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.bpI, this.eig, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
