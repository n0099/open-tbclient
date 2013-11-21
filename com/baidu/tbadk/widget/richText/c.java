package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f984a;
    private SpannableStringBuilder b = null;
    private f c = null;
    private ArrayList<e> d = null;
    private p e = null;
    private d f;

    public c(int i) {
        this.f984a = 0;
        this.f = null;
        this.f984a = i;
        this.f = new d(this);
    }

    public int a() {
        return this.f984a;
    }

    public ArrayList<e> b() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        return this.d;
    }

    public void a(int i, int i2) {
        if (this.d != null) {
            Iterator<e> it = this.d.iterator();
            while (it.hasNext()) {
                e next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.a(0, i2);
                }
            }
        }
    }

    public void b(int i, int i2) {
        if (this.d != null) {
            Iterator<e> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void a(CharSequence charSequence) {
        if ((this.f984a == 1 || this.f984a == 768) && charSequence != null) {
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.append(charSequence);
            this.f.f985a = this.b.length();
        }
    }

    public void a(String str) {
        if (this.f984a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public f c() {
        if (this.f984a != 8) {
            return null;
        }
        return this.c;
    }

    public void a(f fVar) {
        if (this.f984a == 8) {
            this.c = fVar;
        }
    }

    public SpannableStringBuilder d() {
        return this.b;
    }

    public p e() {
        if (this.f984a == 512 || this.f984a == 768) {
            return this.e;
        }
        return null;
    }

    public void a(p pVar) {
        if (this.f984a == 512 || this.f984a == 768) {
            this.e = pVar;
        }
    }

    public String toString() {
        if (this.f984a == 1) {
            if (this.b != null) {
                return this.b.toString();
            }
        } else if (this.f984a == 8 && this.c != null) {
            return this.c.f();
        }
        return "";
    }

    public d f() {
        if (this.f984a != 1) {
            return null;
        }
        return this.f;
    }
}
