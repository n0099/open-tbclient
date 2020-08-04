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
/* loaded from: classes17.dex */
public class EllipsizingTextView extends TextView {
    private final List<a> iqE;
    private boolean iqF;
    private boolean iqG;
    private boolean iqH;
    private String iqI;
    private float iqJ;
    private float lineSpacingMultiplier;
    private int maxLines;

    /* loaded from: classes17.dex */
    public interface a {
        void oR(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.iqE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iqJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iqJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.iqJ = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.iqE.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.iqG = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.iqJ = f;
        this.lineSpacingMultiplier = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.iqH) {
            this.iqI = charSequence.toString();
            this.iqG = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.iqG) {
            super.setEllipsize(null);
            ckY();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ckY() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.iqI;
        if (maxLines != -1) {
            Layout GH = GH(str);
            if (GH.getLineCount() > maxLines) {
                String trim = this.iqI.substring(0, GH.getLineEnd(maxLines - 1)).trim();
                while (GH(trim + StringHelper.STRING_MORE).getLineCount() > maxLines) {
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
                    this.iqH = true;
                    try {
                        setText(str);
                    } finally {
                        this.iqH = false;
                    }
                }
                this.iqG = false;
                if (z == this.iqF) {
                    this.iqF = z;
                    for (a aVar : this.iqE) {
                        aVar.oR(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.iqG = false;
        if (z == this.iqF) {
        }
    }

    private Layout GH(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.iqJ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
