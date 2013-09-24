package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f840a;
    private SpannableStringBuilder b = null;
    private e c = null;
    private ArrayList<d> d = null;
    private o e = null;

    public c(int i) {
        this.f840a = 0;
        this.f840a = i;
    }

    public int a() {
        return this.f840a;
    }

    public ArrayList<d> b() {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        return this.d;
    }

    public void a(int i, int i2) {
        if (this.d != null) {
            Iterator<d> it = this.d.iterator();
            while (it.hasNext()) {
                d next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.a(0, i2);
                }
            }
        }
    }

    public void b(int i, int i2) {
        if (this.d != null) {
            Iterator<d> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void a(CharSequence charSequence) {
        if (this.f840a == 1 && charSequence != null) {
            if (this.b == null) {
                this.b = new SpannableStringBuilder("");
            }
            this.b.append(charSequence);
        }
    }

    public void a(String str) {
        if (this.f840a == 32 && str != null) {
            this.b = new SpannableStringBuilder(str);
        }
    }

    public e c() {
        if (this.f840a != 8) {
            return null;
        }
        return this.c;
    }

    public void a(e eVar) {
        if (this.f840a == 8) {
            this.c = eVar;
        }
    }

    public SpannableStringBuilder d() {
        return this.b;
    }

    public o e() {
        if (this.f840a != 512) {
            return null;
        }
        return this.e;
    }

    public void a(o oVar) {
        if (this.f840a == 512) {
            this.e = oVar;
        }
    }

    public String toString() {
        if (this.f840a == 1) {
            if (this.b != null) {
                return this.b.toString();
            }
        } else if (this.f840a == 8 && this.c != null) {
            return this.c.e();
        }
        return "";
    }
}
