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
    private boolean NA;
    private boolean NB;
    private boolean NC;
    private String ND;
    private float NE;
    private float NF;
    private final List<i> Nz;
    private int maxLines;

    public EllipsizingTextView(Context context) {
        super(context);
        this.Nz = new ArrayList();
        this.maxLines = -1;
        this.NE = 1.0f;
        this.NF = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nz = new ArrayList();
        this.maxLines = -1;
        this.NE = 1.0f;
        this.NF = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nz = new ArrayList();
        this.maxLines = -1;
        this.NE = 1.0f;
        this.NF = 0.0f;
    }

    public void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException();
        }
        this.Nz.add(iVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.NB = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.NF = f;
        this.NE = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.NC) {
            this.ND = charSequence.toString();
            this.NB = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.NB) {
            super.setEllipsize(null);
            pV();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void pV() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.ND;
        if (maxLines != -1) {
            Layout cJ = cJ(str);
            if (cJ.getLineCount() > maxLines) {
                String trim = this.ND.substring(0, cJ.getLineEnd(maxLines - 1)).trim();
                while (cJ(String.valueOf(trim) + "...").getLineCount() > maxLines) {
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
                    this.NC = true;
                    try {
                        setText(str);
                    } finally {
                        this.NC = false;
                    }
                }
                this.NB = false;
                if (z == this.NA) {
                    this.NA = z;
                    for (i iVar : this.Nz) {
                        iVar.ak(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.NB = false;
        if (z == this.NA) {
        }
    }

    private Layout cJ(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.NE, this.NF, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
