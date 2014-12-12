package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder ajj;
    private g ajk;
    private ArrayList<f> ajl;
    private u ajm;
    private d ajn;
    private e ajo;
    private int ajp;
    private int mType;

    public c() {
        this.mType = 0;
        this.ajj = null;
        this.ajk = null;
        this.ajl = null;
        this.ajm = null;
        this.ajn = null;
    }

    public c(int i) {
        this.mType = 0;
        this.ajj = null;
        this.ajk = null;
        this.ajl = null;
        this.ajm = null;
        this.ajn = null;
        this.mType = i;
        this.ajn = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> zP() {
        if (this.ajl == null) {
            this.ajl = new ArrayList<>();
        }
        return this.ajl;
    }

    public void E(int i, int i2) {
        if (this.ajl != null) {
            Iterator<f> it = this.ajl.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.G(0, i2);
                }
            }
        }
    }

    public void F(int i, int i2) {
        if (this.ajl != null) {
            Iterator<f> it = this.ajl.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.ajj == null) {
                this.ajj = new SpannableStringBuilder("");
            }
            this.ajj.append(charSequence);
            this.ajn.ajq = this.ajj.length();
        }
    }

    public void eJ(String str) {
        if (this.mType == 32 && str != null) {
            this.ajj = new SpannableStringBuilder(str);
        }
    }

    public g zQ() {
        if (this.mType != 8) {
            return null;
        }
        return this.ajk;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.ajk = gVar;
        }
    }

    public SpannableStringBuilder zR() {
        return this.ajj;
    }

    public u zS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajm;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.ajm = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.ajj != null) {
                return this.ajj.toString();
            }
        } else if (this.mType == 8) {
            if (this.ajk != null) {
                return this.ajk.zY();
            }
        } else if (this.mType == 17 && this.ajo != null) {
            return this.ajo.ZO.Zo;
        }
        return "";
    }

    public d zT() {
        if (this.mType != 1) {
            return null;
        }
        return this.ajn;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.ajo = eVar;
        }
    }

    public e zU() {
        return this.ajo;
    }

    public int zV() {
        return this.ajp;
    }

    public void dX(int i) {
        this.ajp = i;
    }
}
