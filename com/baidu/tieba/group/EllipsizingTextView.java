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
    private final List<a> jHN;
    private boolean jHO;
    private boolean jHP;
    private boolean jHQ;
    private String jHR;
    private float jHS;
    private float lineSpacingMultiplier;
    private int maxLines;

    /* loaded from: classes23.dex */
    public interface a {
        void ro(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.jHN = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jHS = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jHN = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jHS = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jHN = new ArrayList();
        this.maxLines = -1;
        this.lineSpacingMultiplier = 1.0f;
        this.jHS = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.jHN.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.jHP = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.jHS = f;
        this.lineSpacingMultiplier = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.jHQ) {
            this.jHR = charSequence.toString();
            this.jHP = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jHP) {
            super.setEllipsize(null);
            cNb();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cNb() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.jHR;
        if (maxLines != -1) {
            Layout Mg = Mg(str);
            if (Mg.getLineCount() > maxLines) {
                String trim = this.jHR.substring(0, Mg.getLineEnd(maxLines - 1)).trim();
                while (Mg(trim + StringHelper.STRING_MORE).getLineCount() > maxLines) {
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
                    this.jHQ = true;
                    try {
                        setText(str);
                    } finally {
                        this.jHQ = false;
                    }
                }
                this.jHP = false;
                if (z == this.jHO) {
                    this.jHO = z;
                    for (a aVar : this.jHN) {
                        aVar.ro(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.jHP = false;
        if (z == this.jHO) {
        }
    }

    private Layout Mg(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.lineSpacingMultiplier, this.jHS, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
