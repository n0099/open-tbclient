package com.baidu.tieba.im.groupInfo;

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

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f1734a;
    private boolean b;
    private boolean c;
    private boolean d;
    private String e;
    private int f;
    private float g;
    private float h;

    public EllipsizingTextView(Context context) {
        super(context);
        this.f1734a = new ArrayList();
        this.f = -1;
        this.g = 1.0f;
        this.h = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1734a = new ArrayList();
        this.f = -1;
        this.g = 1.0f;
        this.h = 0.0f;
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1734a = new ArrayList();
        this.f = -1;
        this.g = 1.0f;
        this.h = 0.0f;
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new NullPointerException();
        }
        this.f1734a.add(cVar);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f = i;
        this.c = true;
    }

    @Override // android.widget.TextView
    public int getMaxLines() {
        return this.f;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.h = f;
        this.g = f2;
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.d) {
            this.e = charSequence.toString();
            this.c = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c) {
            super.setEllipsize(null);
            a();
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        boolean z;
        int maxLines = getMaxLines();
        String str = this.e;
        if (maxLines != -1) {
            Layout a2 = a(str);
            if (a2.getLineCount() > maxLines) {
                String trim = this.e.substring(0, a2.getLineEnd(maxLines - 1)).trim();
                while (a(trim + "...").getLineCount() > maxLines) {
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
                    this.d = true;
                    try {
                        setText(str);
                    } finally {
                        this.d = false;
                    }
                }
                this.c = false;
                if (z == this.b) {
                    this.b = z;
                    for (c cVar : this.f1734a) {
                        cVar.a(z);
                    }
                    return;
                }
                return;
            }
        }
        z = false;
        if (!str.equals(getText())) {
        }
        this.c = false;
        if (z == this.b) {
        }
    }

    private Layout a(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.g, this.h, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
