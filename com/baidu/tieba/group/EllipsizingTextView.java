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
    private final List<a> dzi;
    private boolean dzj;
    private boolean dzk;
    private boolean dzl;
    private String dzm;
    private float dzn;
    private float dzo;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gl(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dzi = new ArrayList();
        this.maxLines = -1;
        this.dzn = 1.0f;
        this.dzo = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzi = new ArrayList();
        this.maxLines = -1;
        this.dzn = 1.0f;
        this.dzo = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzi = new ArrayList();
        this.maxLines = -1;
        this.dzn = 1.0f;
        this.dzo = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dzi.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dzk = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dzo = f;
        this.dzn = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dzl) {
            this.dzm = charSequence.toString();
            this.dzk = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dzk) {
            super.setEllipsize(null);
            awL();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void awL() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.dzm;
        if (maxLines != -1) {
            Layout mC = mC(str);
            if (mC.getLineCount() > maxLines) {
                String trim = this.dzm.substring(0, mC.getLineEnd(maxLines - 1)).trim();
                while (mC(trim + "...").getLineCount() > maxLines) {
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
                    this.dzl = true;
                    try {
                        setText(str);
                    } finally {
                        this.dzl = false;
                    }
                }
                this.dzk = false;
                if (z == this.dzj) {
                    this.dzj = z;
                    for (a aVar : this.dzi) {
                        aVar.gl(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.dzk = false;
        if (z == this.dzj) {
        }
    }

    private Layout mC(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dzn, this.dzo, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
