package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aIB;
    private g aIC;
    private ArrayList<e> aID;
    private z aIE;
    private a aIF;
    private d aIG;
    private o aIH;
    private l aII;
    private k aIJ;
    private f aIK;
    private n aIL;
    private int aIM;
    private boolean aIN;
    private int mType;

    public c() {
        this.mType = 0;
        this.aIB = null;
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.aIF = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aIB = null;
        this.aIC = null;
        this.aID = null;
        this.aIE = null;
        this.aIF = null;
        this.mType = i;
        this.aIF = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> Ie() {
        if (this.aID == null) {
            this.aID = new ArrayList<>();
        }
        return this.aID;
    }

    public void J(int i, int i2) {
        if (this.aID != null) {
            Iterator<e> it = this.aID.iterator();
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
        if (this.aID != null) {
            Iterator<e> it = this.aID.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aIB == null) {
                this.aIB = new SpannableStringBuilder("");
            }
            this.aIB.append(charSequence);
            this.aIF.aIO = this.aIB.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aIB = new SpannableStringBuilder(str);
        }
    }

    public g If() {
        if (this.mType != 8) {
            return null;
        }
        return this.aIC;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aIC = gVar;
        }
    }

    public SpannableStringBuilder Ig() {
        return this.aIB;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aIB != null) {
            this.aIB.clear();
            this.aIB.append((CharSequence) spannableStringBuilder);
        }
    }

    public z Ih() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIE;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aIE = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aIB != null) {
                return this.aIB.toString();
            }
        } else if (this.mType == 8) {
            if (this.aIC != null) {
                return this.aIC.Iu();
            }
        } else if (this.mType == 17 && this.aIG != null) {
            return this.aIG.ayk.axL;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aIO = 0;
        public int aIP = 0;
        public int aIQ = 0;
        public boolean aIR;

        public a() {
        }
    }

    public a Ii() {
        if (this.mType != 1) {
            return null;
        }
        return this.aIF;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aIH = oVar;
        }
    }

    public o Ij() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIH;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aIG = dVar;
        }
    }

    public d Ik() {
        return this.aIG;
    }

    public int Il() {
        return this.aIM;
    }

    public void fu(int i) {
        this.aIM = i;
    }

    public l Im() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aII;
    }

    public void a(l lVar) {
        this.aII = lVar;
    }

    public k In() {
        return this.aIJ;
    }

    public void a(k kVar) {
        this.aIJ = kVar;
    }

    public f Io() {
        return this.aIK;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aIK = fVar;
        }
    }

    public n Ip() {
        return this.aIL;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aIL = nVar;
        }
    }

    public void bY(boolean z) {
        this.aIN = z;
    }

    public boolean Iq() {
        return this.aIN;
    }
}
