package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private int a;
    private String b = null;
    private SpannableStringBuilder c = null;
    private e d = null;
    private ArrayList e = null;

    public c(int i) {
        this.a = 0;
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public ArrayList b() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        return this.e;
    }

    public void a(int i, int i2) {
        if (this.e != null) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                Rect bounds = dVar.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    dVar.a(0, i2);
                }
            }
        }
    }

    public void b(int i, int i2) {
        if (this.e != null) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((d) it.next()).setBounds(0, 0, i, i2);
            }
        }
    }

    public void a(SpannableString spannableString) {
        if (this.a == 1 && spannableString != null) {
            if (this.c == null) {
                this.c = new SpannableStringBuilder("");
            }
            this.c.append((CharSequence) spannableString);
        }
    }

    public e c() {
        if (this.a != 8) {
            return null;
        }
        return this.d;
    }

    public void a(e eVar) {
        if (this.a == 8) {
            this.d = eVar;
        }
    }

    public SpannableStringBuilder d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }
}
