package com.baidu.tieba.group;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class EllipsizingTextView extends TextView {
    private final List<a> iMu;
    private boolean iMv;
    private boolean iMw;
    private boolean iMx;
    private String iMy;
    private float iMz;
    private float lineSpacingMultiplier;
    private int maxLines;

    /* loaded from: classes22.dex */
    public interface a {
        void pE(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.iMu = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iMz = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMu = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iMz = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMu = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iMz = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.iMu.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.iMw = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.iMz = f;
        this.lineSpacingMultiplier = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.iMx) {
            this.iMy = charSequence.toString();
            this.iMw = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.iMw) {
            super.setEllipsize(null);
            czb();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void czb() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.iMy;
        if (maxLines != -1) {
            Layout JW = JW(str);
            if (JW.getLineCount() > maxLines) {
                String trim = this.iMy.substring(0, JW.getLineEnd(maxLines - 1)).trim();
                while (JW(trim + StringHelper.STRING_MORE).getLineCount() > maxLines) {
                    if (trim.length() > StringHelper.STRING_MORE.length()) {
                        trim = trim.substring(0, trim.length() - StringHelper.STRING_MORE.length());
                    }
                    int lastIndexOf = trim.lastIndexOf(32);
                    if (lastIndexOf == -1) {
                        break;
                    }
                    trim = trim.substring(0, lastIndexOf);
                }
                str = trim + StringHelper.STRING_MORE;
                z = true;
                if (!str.equals(getText())) {
                    this.iMx = true;
                    try {
                        setText(str);
                    } finally {
                        this.iMx = false;
                    }
                }
                this.iMw = false;
                if (z == this.iMv) {
                    this.iMv = z;
                    for (a aVar : this.iMu) {
                        aVar.pE(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.iMw = false;
        if (z == this.iMv) {
        }
    }

    private Layout JW(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.iMz, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
