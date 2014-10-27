package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder abt;
    private g abu;
    private ArrayList<f> abv;
    private u abw;
    private d abx;
    private e aby;
    private int abz;
    private int mType;

    public c() {
        this.mType = 0;
        this.abt = null;
        this.abu = null;
        this.abv = null;
        this.abw = null;
        this.abx = null;
    }

    public c(int i) {
        this.mType = 0;
        this.abt = null;
        this.abu = null;
        this.abv = null;
        this.abw = null;
        this.abx = null;
        this.mType = i;
        this.abx = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> vC() {
        if (this.abv == null) {
            this.abv = new ArrayList<>();
        }
        return this.abv;
    }

    public void A(int i, int i2) {
        if (this.abv != null) {
            Iterator<f> it = this.abv.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.C(0, i2);
                }
            }
        }
    }

    public void B(int i, int i2) {
        if (this.abv != null) {
            Iterator<f> it = this.abv.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.abt == null) {
                this.abt = new SpannableStringBuilder("");
            }
            this.abt.append(charSequence);
            this.abx.abA = this.abt.length();
        }
    }

    public void dQ(String str) {
        if (this.mType == 32 && str != null) {
            this.abt = new SpannableStringBuilder(str);
        }
    }

    public g vD() {
        if (this.mType != 8) {
            return null;
        }
        return this.abu;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.abu = gVar;
        }
    }

    public SpannableStringBuilder vE() {
        return this.abt;
    }

    public u vF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.abw;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.abw = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.abt != null) {
                return this.abt.toString();
            }
        } else if (this.mType == 8) {
            if (this.abu != null) {
                return this.abu.vL();
            }
        } else if (this.mType == 17 && this.aby != null) {
            return this.aby.TF.Tf;
        }
        return "";
    }

    public d vG() {
        if (this.mType != 1) {
            return null;
        }
        return this.abx;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.aby = eVar;
        }
    }

    public e vH() {
        return this.aby;
    }

    public int vI() {
        return this.abz;
    }

    public void du(int i) {
        this.abz = i;
    }
}
