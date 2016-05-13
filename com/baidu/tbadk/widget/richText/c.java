package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aDZ;
    private g aEa;
    private ArrayList<e> aEb;
    private z aEc;
    private a aEd;
    private d aEe;
    private o aEf;
    private l aEg;
    private k aEh;
    private f aEi;
    private n aEj;
    private int aEk;
    private int mType;

    public c() {
        this.mType = 0;
        this.aDZ = null;
        this.aEa = null;
        this.aEb = null;
        this.aEc = null;
        this.aEd = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aDZ = null;
        this.aEa = null;
        this.aEb = null;
        this.aEc = null;
        this.aEd = null;
        this.mType = i;
        this.aEd = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> GI() {
        if (this.aEb == null) {
            this.aEb = new ArrayList<>();
        }
        return this.aEb;
    }

    public void G(int i, int i2) {
        if (this.aEb != null) {
            Iterator<e> it = this.aEb.iterator();
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
        if (this.aEb != null) {
            Iterator<e> it = this.aEb.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aDZ == null) {
                this.aDZ = new SpannableStringBuilder("");
            }
            this.aDZ.append(charSequence);
            this.aEd.aEl = this.aDZ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aDZ = new SpannableStringBuilder(str);
        }
    }

    public g GJ() {
        if (this.mType != 8) {
            return null;
        }
        return this.aEa;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aEa = gVar;
        }
    }

    public SpannableStringBuilder GK() {
        return this.aDZ;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aDZ != null) {
            this.aDZ.clear();
            this.aDZ.append((CharSequence) spannableStringBuilder);
        }
    }

    public z GL() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aEc;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aEc = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aDZ != null) {
                return this.aDZ.toString();
            }
        } else if (this.mType == 8) {
            if (this.aEa != null) {
                return this.aEa.GW();
            }
        } else if (this.mType == 17 && this.aEe != null) {
            return this.aEe.aty.asZ;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aEl = 0;
        public int aEm = 0;
        public int aEn = 0;
        public boolean aEo;

        public a() {
        }
    }

    public a GM() {
        if (this.mType != 1) {
            return null;
        }
        return this.aEd;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aEf = oVar;
        }
    }

    public o GN() {
        if (this.mType != 32) {
            return null;
        }
        return this.aEf;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aEe = dVar;
        }
    }

    public d GO() {
        return this.aEe;
    }

    public int GP() {
        return this.aEk;
    }

    public void fa(int i) {
        this.aEk = i;
    }

    public l GQ() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aEg;
    }

    public void a(l lVar) {
        this.aEg = lVar;
    }

    public k GR() {
        return this.aEh;
    }

    public void a(k kVar) {
        this.aEh = kVar;
    }

    public f GS() {
        return this.aEi;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aEi = fVar;
        }
    }

    public n GT() {
        return this.aEj;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aEj = nVar;
        }
    }
}
