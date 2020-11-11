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
/* loaded from: classes23.dex */
public class EllipsizingTextView extends TextView {
    private final List<a> jtE;
    private boolean jtF;
    private boolean jtG;
    private boolean jtH;
    private String jtI;
    private float jtJ;
    private float lineSpacingMultiplier;
    private int maxLines;

    /* loaded from: classes23.dex */
    public interface a {
        void qK(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.jtE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jtJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jtJ = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtE = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jtJ = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.jtE.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.jtG = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.jtJ = f;
        this.lineSpacingMultiplier = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.jtH) {
            this.jtI = charSequence.toString();
            this.jtG = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jtG) {
            super.setEllipsize(null);
            cIh();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cIh() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.jtI;
        if (maxLines != -1) {
            Layout Ly = Ly(str);
            if (Ly.getLineCount() > maxLines) {
                String trim = this.jtI.substring(0, Ly.getLineEnd(maxLines - 1)).trim();
                while (Ly(trim + StringHelper.STRING_MORE).getLineCount() > maxLines) {
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
                    this.jtH = true;
                    try {
                        setText(str);
                    } finally {
                        this.jtH = false;
                    }
                }
                this.jtG = false;
                if (z == this.jtF) {
                    this.jtF = z;
                    for (a aVar : this.jtE) {
                        aVar.qK(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.jtG = false;
        if (z == this.jtF) {
        }
    }

    private Layout Ly(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.jtJ, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
