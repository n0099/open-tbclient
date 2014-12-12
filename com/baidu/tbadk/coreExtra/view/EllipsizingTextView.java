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
    private final List<i> To;
    private boolean Tp;
    private boolean Tq;
    private boolean Tr;
    private String Ts;
    private float Tt;
    private float Tu;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.To = new ArrayList();
        this.maxLines = -1;
        this.Tt = 1.0f;
        this.Tu = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.To = new ArrayList();
        this.maxLines = -1;
        this.Tt = 1.0f;
        this.Tu = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.To = new ArrayList();
        this.maxLines = -1;
        this.Tt = 1.0f;
        this.Tu = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.To.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.Tq = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.Tu = f;
        this.Tt = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.Tr) {
            this.Ts = charSequence.toString();
            this.Tq = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Tq) {
            super.setEllipsize(null);
            tp();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void tp() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.Ts;
        if (maxLines != -1) {
            Layout dF = dF(str);
            if (dF.getLineCount() > maxLines) {
                String trim = this.Ts.substring(0, dF.getLineEnd(maxLines - 1)).trim();
                while (dF(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.Tr = true;
                    try {
                        setText(str);
                    } finally {
                        this.Tr = false;
                    }
                }
                this.Tq = false;
                if (z == this.Tp) {
                    this.Tp = z;
                    for (i iVar : this.To) {
                        iVar.ay(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.Tq = false;
        if (z == this.Tp) {
        }
    }

    private Layout dF(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.Tt, this.Tu, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
