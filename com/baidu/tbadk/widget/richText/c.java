package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aAk;
    private f aAl;
    private ArrayList<e> aAm;
    private v aAn;
    private a aAo;
    private d aAp;
    private m aAq;
    private k aAr;
    private j aAs;
    private int aAt;
    private int mType;

    public c() {
        this.mType = 0;
        this.aAk = null;
        this.aAl = null;
        this.aAm = null;
        this.aAn = null;
        this.aAo = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aAk = null;
        this.aAl = null;
        this.aAm = null;
        this.aAn = null;
        this.aAo = null;
        this.mType = i;
        this.aAo = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> EM() {
        if (this.aAm == null) {
            this.aAm = new ArrayList<>();
        }
        return this.aAm;
    }

    public void N(int i, int i2) {
        if (this.aAm != null) {
            Iterator<e> it = this.aAm.iterator();
            while (it.hasNext()) {
                e next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.P(0, i2);
                }
            }
        }
    }

    public void O(int i, int i2) {
        if (this.aAm != null) {
            Iterator<e> it = this.aAm.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aAk == null) {
                this.aAk = new SpannableStringBuilder("");
            }
            this.aAk.append(charSequence);
            this.aAo.aAu = this.aAk.length();
        }
    }

    public void fR(String str) {
        if (this.mType == 32 && str != null) {
            this.aAk = new SpannableStringBuilder(str);
        }
    }

    public f EN() {
        if (this.mType != 8) {
            return null;
        }
        return this.aAl;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aAl = fVar;
        }
    }

    public SpannableStringBuilder EO() {
        return this.aAk;
    }

    public v EP() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aAn;
        }
        return null;
    }

    public void a(v vVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aAn = vVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aAk != null) {
                return this.aAk.toString();
            }
        } else if (this.mType == 8) {
            if (this.aAl != null) {
                return this.aAl.EY();
            }
        } else if (this.mType == 17 && this.aAp != null) {
            return this.aAp.ast.arU;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aAu = 0;
        public int aAv = 0;
        public int aAw = 0;
        public boolean aAx;

        public a() {
        }
    }

    public a EQ() {
        if (this.mType != 1) {
            return null;
        }
        return this.aAo;
    }

    public void a(m mVar) {
        if (this.mType == 32) {
            this.aAq = mVar;
        }
    }

    public m ER() {
        if (this.mType != 32) {
            return null;
        }
        return this.aAq;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aAp = dVar;
        }
    }

    public d ES() {
        return this.aAp;
    }

    public int ET() {
        return this.aAt;
    }

    public void eI(int i) {
        this.aAt = i;
    }

    public k EU() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aAr;
    }

    public void a(k kVar) {
        this.aAr = kVar;
    }

    public j EV() {
        return this.aAs;
    }

    public void a(j jVar) {
        this.aAs = jVar;
    }
}
