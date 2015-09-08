package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aCR;
    private f aCS;
    private ArrayList<e> aCT;
    private r aCU;
    private a aCV;
    private d aCW;
    private j aCX;
    private int aCY;
    private int mType;

    public c() {
        this.mType = 0;
        this.aCR = null;
        this.aCS = null;
        this.aCT = null;
        this.aCU = null;
        this.aCV = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aCR = null;
        this.aCS = null;
        this.aCT = null;
        this.aCU = null;
        this.aCV = null;
        this.mType = i;
        this.aCV = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> Fk() {
        if (this.aCT == null) {
            this.aCT = new ArrayList<>();
        }
        return this.aCT;
    }

    public void N(int i, int i2) {
        if (this.aCT != null) {
            Iterator<e> it = this.aCT.iterator();
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
        if (this.aCT != null) {
            Iterator<e> it = this.aCT.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aCR == null) {
                this.aCR = new SpannableStringBuilder("");
            }
            this.aCR.append(charSequence);
            this.aCV.aCZ = this.aCR.length();
        }
    }

    public void fL(String str) {
        if (this.mType == 32 && str != null) {
            this.aCR = new SpannableStringBuilder(str);
        }
    }

    public f Fl() {
        if (this.mType != 8) {
            return null;
        }
        return this.aCS;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aCS = fVar;
        }
    }

    public SpannableStringBuilder Fm() {
        return this.aCR;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aCR != null) {
            this.aCR.clear();
            this.aCR.append((CharSequence) spannableStringBuilder);
        }
    }

    public r Fn() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aCU;
        }
        return null;
    }

    public void a(r rVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aCU = rVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aCR != null) {
                return this.aCR.toString();
            }
        } else if (this.mType == 8) {
            if (this.aCS != null) {
                return this.aCS.Fu();
            }
        } else if (this.mType == 17 && this.aCW != null) {
            return this.aCW.avh.auI;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aCZ = 0;
        public int aDa = 0;
        public int aDb = 0;
        public boolean aDc;

        public a() {
        }
    }

    public a Fo() {
        if (this.mType != 1) {
            return null;
        }
        return this.aCV;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.aCX = jVar;
        }
    }

    public j Fp() {
        if (this.mType != 32) {
            return null;
        }
        return this.aCX;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aCW = dVar;
        }
    }

    public d Fq() {
        return this.aCW;
    }

    public int Fr() {
        return this.aCY;
    }

    public void eG(int i) {
        this.aCY = i;
    }
}
