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
    private final List<i> aea;
    private boolean aeb;
    private boolean aec;
    private boolean aed;
    private String aee;
    private float aef;
    private float aeg;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.aea = new ArrayList();
        this.maxLines = -1;
        this.aef = 1.0f;
        this.aeg = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aea = new ArrayList();
        this.maxLines = -1;
        this.aef = 1.0f;
        this.aeg = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aea = new ArrayList();
        this.maxLines = -1;
        this.aef = 1.0f;
        this.aeg = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.aea.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.aec = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.aeg = f;
        this.aef = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.aed) {
            this.aee = charSequence.toString();
            this.aec = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.aec) {
            super.setEllipsize(null);
            wZ();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wZ() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.aee;
        if (maxLines != -1) {
            Layout dM = dM(str);
            if (dM.getLineCount() > maxLines) {
                String trim = this.aee.substring(0, dM.getLineEnd(maxLines - 1)).trim();
                while (dM(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.aed = true;
                    try {
                        setText(str);
                    } finally {
                        this.aed = false;
                    }
                }
                this.aec = false;
                if (z == this.aeb) {
                    this.aeb = z;
                    for (i iVar : this.aea) {
                        iVar.aF(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.aec = false;
        if (z == this.aeb) {
        }
    }

    private Layout dM(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.aef, this.aeg, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
