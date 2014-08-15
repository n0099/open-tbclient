package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int a;
    private SpannableStringBuilder b = null;
    private g c = null;
    private ArrayList<f> d = null;
    private u e = null;
    private d f;
    private e g;
    private int h;

    public c(int i) {
        this.a = 0;
        this.f = null;
        this.a = i;
        this.f = new d(this);
    }

    public int a() {
        return this.a;
    }

    public ArrayList<f> b() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        return this.d;
    }

    public void a(int i, int i2) {
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

    public void b(int i, int i2) {
        if (this.d != null) {
            Iterator<f> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void a(CharSequence charSequence) {
        if ((this.a == 1 || this.a == 768) && charSequence != null) {
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.append(charSequence);
            this.f.a = this.b.length();
        }
    }

    public void a(String str) {
        if (this.a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public g c() {
        if (this.a != 8) {
            return null;
        }
        return this.c;
    }

    public void a(g gVar) {
        if (this.a == 8) {
            this.c = gVar;
        }
    }

    public SpannableStringBuilder d() {
        return this.b;
    }

    public u e() {
        if (this.a == 512 || this.a == 768) {
            return this.e;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.a == 512 || this.a == 768) {
            this.e = uVar;
        }
    }

    public String toString() {
        if (this.a == 1) {
            if (this.b != null) {
                return this.b.toString();
            }
        } else if (this.a == 8) {
            if (this.c != null) {
                return this.c.f();
            }
        } else if (this.a == 17 && this.g != null) {
            return this.g.b.b;
        }
        return "";
    }

    public d f() {
        if (this.a != 1) {
            return null;
        }
        return this.f;
    }

    public void a(e eVar) {
        if (this.a == 17) {
            this.g = eVar;
        }
    }

    public e g() {
        return this.g;
    }

    public void a(int i) {
        this.h = i;
    }
}
