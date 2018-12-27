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
    private float bti;
    private final List<a> erM;
    private boolean erN;
    private boolean erO;
    private boolean erP;
    private String erQ;
    private float erR;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void hJ(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.erM = new ArrayList();
        this.maxLines = -1;
        this.bti = 1.0f;
        this.erR = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.erM = new ArrayList();
        this.maxLines = -1;
        this.bti = 1.0f;
        this.erR = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.erM = new ArrayList();
        this.maxLines = -1;
        this.bti = 1.0f;
        this.erR = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.erM.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.erO = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.erR = f;
        this.bti = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.erP) {
            this.erQ = charSequence.toString();
            this.erO = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.erO) {
            super.setEllipsize(null);
            aKx();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void aKx() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.erQ;
        if (maxLines != -1) {
            Layout pg = pg(str);
            if (pg.getLineCount() > maxLines) {
                String trim = this.erQ.substring(0, pg.getLineEnd(maxLines - 1)).trim();
                while (pg(trim + "...").getLineCount() > maxLines) {
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
                    this.erP = true;
                    try {
                        setText(str);
                    } finally {
                        this.erP = false;
                    }
                }
                this.erO = false;
                if (z == this.erN) {
                    this.erN = z;
                    for (a aVar : this.erM) {
                        aVar.hJ(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.erO = false;
        if (z == this.erN) {
        }
    }

    private Layout pg(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.bti, this.erR, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
