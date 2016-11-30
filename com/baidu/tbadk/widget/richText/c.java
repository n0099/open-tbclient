package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aIQ;
    private g aIR;
    private ArrayList<e> aIS;
    private z aIT;
    private a aIU;
    private d aIV;
    private o aIW;
    private l aIX;
    private k aIY;
    private f aIZ;
    private n aJa;
    private int aJb;
    private boolean aJc;
    private int mType;

    public c() {
        this.mType = 0;
        this.aIQ = null;
        this.aIR = null;
        this.aIS = null;
        this.aIT = null;
        this.aIU = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aIQ = null;
        this.aIR = null;
        this.aIS = null;
        this.aIT = null;
        this.aIU = null;
        this.mType = i;
        this.aIU = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> Ig() {
        if (this.aIS == null) {
            this.aIS = new ArrayList<>();
        }
        return this.aIS;
    }

    public void J(int i, int i2) {
        if (this.aIS != null) {
            Iterator<e> it = this.aIS.iterator();
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
        if (this.aIS != null) {
            Iterator<e> it = this.aIS.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aIQ == null) {
                this.aIQ = new SpannableStringBuilder("");
            }
            this.aIQ.append(charSequence);
            this.aIU.aJd = this.aIQ.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aIQ = new SpannableStringBuilder(str);
        }
    }

    public g Ih() {
        if (this.mType != 8) {
            return null;
        }
        return this.aIR;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aIR = gVar;
        }
    }

    public SpannableStringBuilder Ii() {
        return this.aIQ;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aIQ != null) {
            this.aIQ.clear();
            this.aIQ.append((CharSequence) spannableStringBuilder);
        }
    }

    public z Ij() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIT;
        }
        return null;
    }

    public void a(z zVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aIT = zVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aIQ != null) {
                return this.aIQ.toString();
            }
        } else if (this.mType == 8) {
            if (this.aIR != null) {
                return this.aIR.Iw();
            }
        } else if (this.mType == 17 && this.aIV != null) {
            return this.aIV.ayE.ayf;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aJd = 0;
        public int aJe = 0;
        public int aJf = 0;
        public boolean aJg;

        public a() {
        }
    }

    public a Ik() {
        if (this.mType != 1) {
            return null;
        }
        return this.aIU;
    }

    public void a(o oVar) {
        if (this.mType == 32) {
            this.aIW = oVar;
        }
    }

    public o Il() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIW;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aIV = dVar;
        }
    }

    public d Im() {
        return this.aIV;
    }

    public int In() {
        return this.aJb;
    }

    public void fw(int i) {
        this.aJb = i;
    }

    public l Io() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aIX;
    }

    public void a(l lVar) {
        this.aIX = lVar;
    }

    public k Ip() {
        return this.aIY;
    }

    public void a(k kVar) {
        this.aIY = kVar;
    }

    public f Iq() {
        return this.aIZ;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aIZ = fVar;
        }
    }

    public n Ir() {
        return this.aJa;
    }

    public void a(n nVar) {
        if (this.mType == 1792) {
            this.aJa = nVar;
        }
    }

    public void cc(boolean z) {
        this.aJc = z;
    }

    public boolean Is() {
        return this.aJc;
    }
}
