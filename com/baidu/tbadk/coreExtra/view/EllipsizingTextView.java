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
    private final List<i> adS;
    private boolean adT;
    private boolean adU;
    private boolean adV;
    private String adW;
    private float adX;
    private float adY;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.adS = new ArrayList();
        this.maxLines = -1;
        this.adX = 1.0f;
        this.adY = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adS = new ArrayList();
        this.maxLines = -1;
        this.adX = 1.0f;
        this.adY = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adS = new ArrayList();
        this.maxLines = -1;
        this.adX = 1.0f;
        this.adY = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.adS.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.adU = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.adY = f;
        this.adX = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.adV) {
            this.adW = charSequence.toString();
            this.adU = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.adU) {
            super.setEllipsize(null);
            wT();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wT() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.adW;
        if (maxLines != -1) {
            Layout dJ = dJ(str);
            if (dJ.getLineCount() > maxLines) {
                String trim = this.adW.substring(0, dJ.getLineEnd(maxLines - 1)).trim();
                while (dJ(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.adV = true;
                    try {
                        setText(str);
                    } finally {
                        this.adV = false;
                    }
                }
                this.adU = false;
                if (z == this.adT) {
                    this.adT = z;
                    for (i iVar : this.adS) {
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
        this.adU = false;
        if (z == this.adT) {
        }
    }

    private Layout dJ(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.adX, this.adY, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
