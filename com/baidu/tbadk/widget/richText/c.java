package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aFj;
    private f aFk;
    private ArrayList<e> aFl;
    private v aFm;
    private a aFn;
    private d aFo;
    private m aFp;
    private k aFq;
    private j aFr;
    private int aFs;
    private int mType;

    public c() {
        this.mType = 0;
        this.aFj = null;
        this.aFk = null;
        this.aFl = null;
        this.aFm = null;
        this.aFn = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aFj = null;
        this.aFk = null;
        this.aFl = null;
        this.aFm = null;
        this.aFn = null;
        this.mType = i;
        this.aFn = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> GW() {
        if (this.aFl == null) {
            this.aFl = new ArrayList<>();
        }
        return this.aFl;
    }

    public void J(int i, int i2) {
        if (this.aFl != null) {
            Iterator<e> it = this.aFl.iterator();
            while (it.hasNext()) {
                e next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.L(0, i2);
                }
            }
        }
    }

    public void K(int i, int i2) {
        if (this.aFl != null) {
            Iterator<e> it = this.aFl.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aFj == null) {
                this.aFj = new SpannableStringBuilder("");
            }
            this.aFj.append(charSequence);
            this.aFn.aFt = this.aFj.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aFj = new SpannableStringBuilder(str);
        }
    }

    public f GX() {
        if (this.mType != 8) {
            return null;
        }
        return this.aFk;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aFk = fVar;
        }
    }

    public SpannableStringBuilder GY() {
        return this.aFj;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aFj != null) {
            this.aFj.clear();
            this.aFj.append((CharSequence) spannableStringBuilder);
        }
    }

    public v GZ() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aFm;
        }
        return null;
    }

    public void a(v vVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aFm = vVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aFj != null) {
                return this.aFj.toString();
            }
        } else if (this.mType == 8) {
            if (this.aFk != null) {
                return this.aFk.Hi();
            }
        } else if (this.mType == 17 && this.aFo != null) {
            return this.aFo.awQ.awr;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aFt = 0;
        public int aFu = 0;
        public int aFv = 0;
        public boolean aFw;

        public a() {
        }
    }

    public a Ha() {
        if (this.mType != 1) {
            return null;
        }
        return this.aFn;
    }

    public void a(m mVar) {
        if (this.mType == 32) {
            this.aFp = mVar;
        }
    }

    public m Hb() {
        if (this.mType != 32) {
            return null;
        }
        return this.aFp;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aFo = dVar;
        }
    }

    public d Hc() {
        return this.aFo;
    }

    public int Hd() {
        return this.aFs;
    }

    public void fk(int i) {
        this.aFs = i;
    }

    public k He() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aFq;
    }

    public void a(k kVar) {
        this.aFq = kVar;
    }

    public j Hf() {
        return this.aFr;
    }

    public void a(j jVar) {
        this.aFr = jVar;
    }
}
