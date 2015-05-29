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
    private final List<i> afe;
    private boolean aff;
    private boolean afg;
    private boolean afh;
    private String afi;
    private float afj;
    private float afk;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.afe = new ArrayList();
        this.maxLines = -1;
        this.afj = 1.0f;
        this.afk = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afe = new ArrayList();
        this.maxLines = -1;
        this.afj = 1.0f;
        this.afk = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afe = new ArrayList();
        this.maxLines = -1;
        this.afj = 1.0f;
        this.afk = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.afe.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.afg = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.afk = f;
        this.afj = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.afh) {
            this.afi = charSequence.toString();
            this.afg = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.afg) {
            super.setEllipsize(null);
            xL();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xL() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.afi;
        if (maxLines != -1) {
            Layout ed = ed(str);
            if (ed.getLineCount() > maxLines) {
                String trim = this.afi.substring(0, ed.getLineEnd(maxLines - 1)).trim();
                while (ed(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.afh = true;
                    try {
                        setText(str);
                    } finally {
                        this.afh = false;
                    }
                }
                this.afg = false;
                if (z == this.aff) {
                    this.aff = z;
                    for (i iVar : this.afe) {
                        iVar.aM(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.afg = false;
        if (z == this.aff) {
        }
    }

    private Layout ed(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.afj, this.afk, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
