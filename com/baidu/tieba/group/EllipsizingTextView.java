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
/* loaded from: classes5.dex */
public class EllipsizingTextView extends TextView {
    private float cPM;
    private final List<a> gdi;
    private boolean gdj;
    private boolean gdk;
    private boolean gdl;
    private String gdm;
    private float gdn;
    private int maxLines;

    /* loaded from: classes5.dex */
    public interface a {
        void lg(boolean z);
    }

    public EllipsizingTextView(Context context) {
        super(context);
        this.gdi = new ArrayList();
        this.maxLines = -1;
        this.cPM = 1.0f;
        this.gdn = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdi = new ArrayList();
        this.maxLines = -1;
        this.cPM = 1.0f;
        this.gdn = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdi = new ArrayList();
        this.maxLines = -1;
        this.cPM = 1.0f;
        this.gdn = 0.0f;
    }

    public void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        }
        this.gdi.add(aVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.gdk = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.maxLines;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.gdn = f;
        this.cPM = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.gdl) {
            this.gdm = charSequence.toString();
            this.gdk = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.gdk) {
            super.setEllipsize(null);
            bvy();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bvy() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.gdm;
        if (maxLines != -1) {
            Layout yt = yt(str);
            if (yt.getLineCount() > maxLines) {
                String trim = this.gdm.substring(0, yt.getLineEnd(maxLines - 1)).trim();
                while (yt(trim + "...").getLineCount() > maxLines) {
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
                    this.gdl = true;
                    try {
                        setText(str);
                    } finally {
                        this.gdl = false;
                    }
                }
                this.gdk = false;
                if (z == this.gdj) {
                    this.gdj = z;
                    for (a aVar : this.gdi) {
                        aVar.lg(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.gdk = false;
        if (z == this.gdj) {
        }
    }

    private Layout yt(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.cPM, this.gdn, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
