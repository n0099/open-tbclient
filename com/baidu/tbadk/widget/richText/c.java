package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c {
    private int a;
    private SpannableStringBuilder b = null;
    private g c = null;
    private ArrayList<f> d = null;
    private t e = null;
    private d f;
    private e g;

    public c(int i) {
        this.a = 0;
        this.f = null;
        this.a = i;
        this.f = new d(this);
    }

    public final int a() {
        return this.a;
    }

    public final ArrayList<f> b() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        return this.d;
    }

    public final void a(int i, int i2) {
        if (this.d != null) {
            Iterator<f> it = this.d.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.a(0, i2);
                }
            }
        }
    }

    public final void b(int i, int i2) {
        if (this.d != null) {
            Iterator<f> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public final void a(CharSequence charSequence) {
        if ((this.a == 1 || this.a == 768) && charSequence != null) {
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.append(charSequence);
            this.f.a = this.b.length();
        }
    }

    public final void a(String str) {
        if (this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public final g c() {
        if (this.a != 8) {
            return null;
        }
        return this.c;
    }

    public final void a(g gVar) {
        if (this.a == 8) {
            this.c = gVar;
        }
    }

    public final SpannableStringBuilder d() {
        return this.b;
    }

    public final t e() {
        if (this.a == 512 || this.a == 768) {
            return this.e;
        }
        return null;
    }

    public final void a(t tVar) {
        if (this.a == 512 || this.a == 768) {
            this.e = tVar;
        }
    }

    public final String toString() {
        if (this.a == 1) {
            if (this.b != null) {
                return this.b.toString();
            }
        } else if (this.a == 8) {
            if (this.c != null) {
                return this.c.f();
            }
        } else if (this.a == 17 && this.g != null) {
            return this.g.c;
        }
        return "";
    }

    public final void a(e eVar) {
        if (this.a == 17) {
            this.g = eVar;
        }
    }

    public final e f() {
        return this.g;
    }
}
