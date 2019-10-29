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
/* loaded from: classes5.dex */
public class EllipsizingTextView extends TextView {
    private float cZe;
    private final List<a> gcG;
    private boolean gcH;
    private boolean gcI;
    private boolean gcJ;
    private String gcK;
    private float gcL;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void kU(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.gcG = new ArrayList();
        this.maxLines = -1;
        this.cZe = 1.0f;
        this.gcL = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcG = new ArrayList();
        this.maxLines = -1;
        this.cZe = 1.0f;
        this.gcL = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gcG = new ArrayList();
        this.maxLines = -1;
        this.cZe = 1.0f;
        this.gcL = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.gcG.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.gcI = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.gcL = f;
        this.cZe = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.gcJ) {
            this.gcK = charSequence.toString();
            this.gcI = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gcI) {
            super.setEllipsize(null);
            bsD();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bsD() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.gcK;
        if (maxLines != -1) {
            Layout wM = wM(str);
            if (wM.getLineCount() > maxLines) {
                String trim = this.gcK.substring(0, wM.getLineEnd(maxLines - 1)).trim();
                while (wM(trim + StringHelper.STRING_MORE).getLineCount() > maxLines) {
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
                    this.gcJ = true;
                    try {
                        setText(str);
                    } finally {
                        this.gcJ = false;
                    }
                }
                this.gcI = false;
                if (z == this.gcH) {
                    this.gcH = z;
                    for (a aVar : this.gcG) {
                        aVar.kU(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.gcI = false;
        if (z == this.gcH) {
        }
    }

    private Layout wM(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cZe, this.gcL, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
