package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aEA;
    private g aEB;
    private ArrayList<e> aEC;
    private z aED;
    private a aEE;
    private d aEF;
    private o aEG;
    private l aEH;
    private k aEI;
    private f aEJ;
    private n aEK;
    private int aEL;
    private int mType;

    public c() {
        this.mType = 0;
        this.aEA = null;
        this.aEB = null;
        this.aEC = null;
        this.aED = null;
        this.aEE = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aEA = null;
        this.aEB = null;
        this.aEC = null;
        this.aED = null;
        this.aEE = null;
        this.mType = i;
        this.aEE = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> GJ() {
        if (this.aEC == null) {
            this.aEC = new ArrayList<>();
        }
        return this.aEC;
    }

    public void G(int i, int i2) {
        if (this.aEC != null) {
            Iterator<e> it = this.aEC.iterator();
            while (it.hasNext()) {
                e next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.I(0, i2);
                }
            }
        }
    }

    public void H(int i, int i2) {
        if (this.aEC != null) {
            Iterator<e> it = this.aEC.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aEA == null) {
                this.aEA = new SpannableStringBuilder("");
            }
            this.aEA.append(charSequence);
            this.aEE.aEM = this.aEA.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aEA = new SpannableStringBuilder(str);
        }
    }

    public g GK() {
        if (this.mType != 8) {
            return null;
        }
        return this.aEB;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aEB = gVar;
        }
    }

    public SpannableStringBuilder GL() {
        return this.aEA;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aEA != null) {
            this.aEA.clear();
            this.aEA.append((CharSequence) spannableStringBuilder);
        }
    }

    public z GM() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aED;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aED = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aEA != null) {
                return this.aEA.toString();
            }
        } else if (this.mType == 8) {
            if (this.aEB != null) {
                return this.aEB.GX();
            }
        } else if (this.mType == 17 && this.aEF != null) {
            return this.aEF.auo.atP;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aEM = 0;
        public int aEN = 0;
        public int aEO = 0;
        public boolean aEP;

        public a() {
        }
    }

    public a GN() {
        if (this.mType != 1) {
            return null;
        }
        return this.aEE;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aEG = oVar;
        }
    }

    public o GO() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEG;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aEF = dVar;
        }
    }

    public d GP() {
        return this.aEF;
    }

    public int GQ() {
        return this.aEL;
    }

    public void fg(int i) {
        this.aEL = i;
    }

    public l GR() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aEH;
    }

    public void a(l lVar) {
        this.aEH = lVar;
    }

    public k GS() {
        return this.aEI;
    }

    public void a(k kVar) {
        this.aEI = kVar;
    }

    public f GT() {
        return this.aEJ;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aEJ = fVar;
        }
    }

    public n GU() {
        return this.aEK;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aEK = nVar;
        }
    }
}
