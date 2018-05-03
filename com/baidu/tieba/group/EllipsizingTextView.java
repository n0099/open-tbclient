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
    private final List<a> dzf;
    private boolean dzg;
    private boolean dzh;
    private boolean dzi;
    private String dzj;
    private float dzk;
    private float dzl;
    private int maxLines;

    /* loaded from: classes3.dex */
    public interface a {
        void gl(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.dzf = new ArrayList();
        this.maxLines = -1;
        this.dzk = 1.0f;
        this.dzl = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dzf = new ArrayList();
        this.maxLines = -1;
        this.dzk = 1.0f;
        this.dzl = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dzf = new ArrayList();
        this.maxLines = -1;
        this.dzk = 1.0f;
        this.dzl = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.dzf.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.dzh = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.dzl = f;
        this.dzk = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.dzi) {
            this.dzj = charSequence.toString();
            this.dzh = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dzh) {
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
        String str = this.dzj;
        if (maxLines != -1) {
            Layout mC = mC(str);
            if (mC.getLineCount() > maxLines) {
                String trim = this.dzj.substring(0, mC.getLineEnd(maxLines - 1)).trim();
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
                    this.dzi = true;
                    try {
                        setText(str);
                    } finally {
                        this.dzi = false;
                    }
                }
                this.dzh = false;
                if (z == this.dzg) {
                    this.dzg = z;
                    for (a aVar : this.dzf) {
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
        this.dzh = false;
        if (z == this.dzg) {
        }
    }

    private Layout mC(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.dzk, this.dzl, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
