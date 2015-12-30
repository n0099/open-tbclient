package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private k aEA;
    private j aEB;
    private int aEC;
    private SpannableStringBuilder aEt;
    private f aEu;
    private ArrayList<e> aEv;
    private v aEw;
    private a aEx;
    private d aEy;
    private m aEz;
    private int mType;

    public c() {
        this.mType = 0;
        this.aEt = null;
        this.aEu = null;
        this.aEv = null;
        this.aEw = null;
        this.aEx = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aEt = null;
        this.aEu = null;
        this.aEv = null;
        this.aEw = null;
        this.aEx = null;
        this.mType = i;
        this.aEx = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> FE() {
        if (this.aEv == null) {
            this.aEv = new ArrayList<>();
        }
        return this.aEv;
    }

    public void O(int i, int i2) {
        if (this.aEv != null) {
            Iterator<e> it = this.aEv.iterator();
            while (it.hasNext()) {
                e next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.Q(0, i2);
                }
            }
        }
    }

    public void P(int i, int i2) {
        if (this.aEv != null) {
            Iterator<e> it = this.aEv.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aEt == null) {
                this.aEt = new SpannableStringBuilder("");
            }
            this.aEt.append(charSequence);
            this.aEx.aED = this.aEt.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aEt = new SpannableStringBuilder(str);
        }
    }

    public f FF() {
        if (this.mType != 8) {
            return null;
        }
        return this.aEu;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aEu = fVar;
        }
    }

    public SpannableStringBuilder FG() {
        return this.aEt;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aEt != null) {
            this.aEt.clear();
            this.aEt.append((CharSequence) spannableStringBuilder);
        }
    }

    public v FH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aEw;
        }
        return null;
    }

    public void a(v vVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aEw = vVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aEt != null) {
                return this.aEt.toString();
            }
        } else if (this.mType == 8) {
            if (this.aEu != null) {
                return this.aEu.FQ();
            }
        } else if (this.mType == 17 && this.aEy != null) {
            return this.aEy.avZ.avz;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aED = 0;
        public int aEE = 0;
        public int aEF = 0;
        public boolean aEG;

        public a() {
        }
    }

    public a FI() {
        if (this.mType != 1) {
            return null;
        }
        return this.aEx;
    }

    public void a(m mVar) {
        if (this.mType == 32) {
            this.aEz = mVar;
        }
    }

    public m FJ() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEz;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aEy = dVar;
        }
    }

    public d FK() {
        return this.aEy;
    }

    public int FL() {
        return this.aEC;
    }

    public void eP(int i) {
        this.aEC = i;
    }

    public k FM() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aEA;
    }

    public void a(k kVar) {
        this.aEA = kVar;
    }

    public j FN() {
        return this.aEB;
    }

    public void a(j jVar) {
        this.aEB = jVar;
    }
}
