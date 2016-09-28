package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aIa;
    private g aIb;
    private ArrayList<e> aIc;
    private z aId;
    private a aIe;
    private d aIf;
    private o aIg;
    private l aIh;
    private k aIi;
    private f aIj;
    private n aIk;
    private int aIl;
    private boolean aIm;
    private int mType;

    public c() {
        this.mType = 0;
        this.aIa = null;
        this.aIb = null;
        this.aIc = null;
        this.aId = null;
        this.aIe = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aIa = null;
        this.aIb = null;
        this.aIc = null;
        this.aId = null;
        this.aIe = null;
        this.mType = i;
        this.aIe = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> Id() {
        if (this.aIc == null) {
            this.aIc = new ArrayList<>();
        }
        return this.aIc;
    }

    public void J(int i, int i2) {
        if (this.aIc != null) {
            Iterator<e> it = this.aIc.iterator();
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
        if (this.aIc != null) {
            Iterator<e> it = this.aIc.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aIa == null) {
                this.aIa = new SpannableStringBuilder("");
            }
            this.aIa.append(charSequence);
            this.aIe.aIn = this.aIa.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aIa = new SpannableStringBuilder(str);
        }
    }

    public g Ie() {
        if (this.mType != 8) {
            return null;
        }
        return this.aIb;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aIb = gVar;
        }
    }

    public SpannableStringBuilder If() {
        return this.aIa;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aIa != null) {
            this.aIa.clear();
            this.aIa.append((CharSequence) spannableStringBuilder);
        }
    }

    public z Ig() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aId;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aId = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aIa != null) {
                return this.aIa.toString();
            }
        } else if (this.mType == 8) {
            if (this.aIb != null) {
                return this.aIb.It();
            }
        } else if (this.mType == 17 && this.aIf != null) {
            return this.aIf.axN.axo;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aIn = 0;
        public int aIo = 0;
        public int aIp = 0;
        public boolean aIq;

        public a() {
        }
    }

    public a Ih() {
        if (this.mType != 1) {
            return null;
        }
        return this.aIe;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aIg = oVar;
        }
    }

    public o Ii() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIg;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aIf = dVar;
        }
    }

    public d Ij() {
        return this.aIf;
    }

    public int Ik() {
        return this.aIl;
    }

    public void ft(int i) {
        this.aIl = i;
    }

    public l Il() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aIh;
    }

    public void a(l lVar) {
        this.aIh = lVar;
    }

    public k Im() {
        return this.aIi;
    }

    public void a(k kVar) {
        this.aIi = kVar;
    }

    public f In() {
        return this.aIj;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aIj = fVar;
        }
    }

    public n Io() {
        return this.aIk;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aIk = nVar;
        }
    }

    public void bX(boolean z) {
        this.aIm = z;
    }

    public boolean Ip() {
        return this.aIm;
    }
}
