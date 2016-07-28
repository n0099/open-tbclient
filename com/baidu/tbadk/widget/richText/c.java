package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private f aFA;
    private n aFB;
    private int aFC;
    private SpannableStringBuilder aFr;
    private g aFs;
    private ArrayList<e> aFt;
    private z aFu;
    private a aFv;
    private d aFw;
    private o aFx;
    private l aFy;
    private k aFz;
    private int mType;

    public c() {
        this.mType = 0;
        this.aFr = null;
        this.aFs = null;
        this.aFt = null;
        this.aFu = null;
        this.aFv = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aFr = null;
        this.aFs = null;
        this.aFt = null;
        this.aFu = null;
        this.aFv = null;
        this.mType = i;
        this.aFv = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> GH() {
        if (this.aFt == null) {
            this.aFt = new ArrayList<>();
        }
        return this.aFt;
    }

    public void G(int i, int i2) {
        if (this.aFt != null) {
            Iterator<e> it = this.aFt.iterator();
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
        if (this.aFt != null) {
            Iterator<e> it = this.aFt.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aFr == null) {
                this.aFr = new SpannableStringBuilder("");
            }
            this.aFr.append(charSequence);
            this.aFv.aFD = this.aFr.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aFr = new SpannableStringBuilder(str);
        }
    }

    public g GI() {
        if (this.mType != 8) {
            return null;
        }
        return this.aFs;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aFs = gVar;
        }
    }

    public SpannableStringBuilder GJ() {
        return this.aFr;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aFr != null) {
            this.aFr.clear();
            this.aFr.append((CharSequence) spannableStringBuilder);
        }
    }

    public z GK() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFu;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aFu = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aFr != null) {
                return this.aFr.toString();
            }
        } else if (this.mType == 8) {
            if (this.aFs != null) {
                return this.aFs.GV();
            }
        } else if (this.mType == 17 && this.aFw != null) {
            return this.aFw.avd.auE;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aFD = 0;
        public int aFE = 0;
        public int aFF = 0;
        public boolean aFG;

        public a() {
        }
    }

    public a GL() {
        if (this.mType != 1) {
            return null;
        }
        return this.aFv;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aFx = oVar;
        }
    }

    public o GM() {
        if (this.mType != 32) {
            return null;
        }
        return this.aFx;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aFw = dVar;
        }
    }

    public d GN() {
        return this.aFw;
    }

    public int GO() {
        return this.aFC;
    }

    public void ff(int i) {
        this.aFC = i;
    }

    public l GP() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aFy;
    }

    public void a(l lVar) {
        this.aFy = lVar;
    }

    public k GQ() {
        return this.aFz;
    }

    public void a(k kVar) {
        this.aFz = kVar;
    }

    public f GR() {
        return this.aFA;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aFA = fVar;
        }
    }

    public n GS() {
        return this.aFB;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aFB = nVar;
        }
    }
}
