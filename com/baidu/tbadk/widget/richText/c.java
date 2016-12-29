package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aIj;
    private g aIk;
    private ArrayList<e> aIl;
    private y aIm;
    private a aIn;
    private d aIo;
    private n aIp;
    private l aIq;
    private k aIr;
    private f aIs;
    private int aIt;
    private boolean aIu;
    private int mType;

    public c() {
        this.mType = 0;
        this.aIj = null;
        this.aIk = null;
        this.aIl = null;
        this.aIm = null;
        this.aIn = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aIj = null;
        this.aIk = null;
        this.aIl = null;
        this.aIm = null;
        this.aIn = null;
        this.mType = i;
        this.aIn = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> HC() {
        if (this.aIl == null) {
            this.aIl = new ArrayList<>();
        }
        return this.aIl;
    }

    public void J(int i, int i2) {
        if (this.aIl != null) {
            Iterator<e> it = this.aIl.iterator();
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
        if (this.aIl != null) {
            Iterator<e> it = this.aIl.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aIj == null) {
                this.aIj = new SpannableStringBuilder("");
            }
            this.aIj.append(charSequence);
            this.aIn.aIv = this.aIj.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aIj = new SpannableStringBuilder(str);
        }
    }

    public g HD() {
        if (this.mType != 8) {
            return null;
        }
        return this.aIk;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.aIk = gVar;
        }
    }

    public SpannableStringBuilder HE() {
        return this.aIj;
    }

    public void b(SpannableStringBuilder spannableStringBuilder) {
        if (this.aIj != null) {
            this.aIj.clear();
            this.aIj.append((CharSequence) spannableStringBuilder);
        }
    }

    public y HF() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aIm;
        }
        return null;
    }

    public void a(y yVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aIm = yVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aIj != null) {
                return this.aIj.toString();
            }
        } else if (this.mType == 8) {
            if (this.aIk != null) {
                return this.aIk.HR();
            }
        } else if (this.mType == 17 && this.aIo != null) {
            return this.aIo.ayb.axC;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aIv = 0;
        public int aIw = 0;
        public int aIx = 0;
        public boolean aIy;

        public a() {
        }
    }

    public a HG() {
        if (this.mType != 1) {
            return null;
        }
        return this.aIn;
    }

    public void a(n nVar) {
        if (this.mType == 32) {
            this.aIp = nVar;
        }
    }

    public n HH() {
        if (this.mType != 32) {
            return null;
        }
        return this.aIp;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aIo = dVar;
        }
    }

    public d HI() {
        return this.aIo;
    }

    public int HJ() {
        return this.aIt;
    }

    public void fw(int i) {
        this.aIt = i;
    }

    public l HK() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aIq;
    }

    public void a(l lVar) {
        this.aIq = lVar;
    }

    public k HL() {
        return this.aIr;
    }

    public void a(k kVar) {
        this.aIr = kVar;
    }

    public f HM() {
        return this.aIs;
    }

    public void a(f fVar) {
        if (this.mType == 1536) {
            this.aIs = fVar;
        }
    }

    public void cb(boolean z) {
        this.aIu = z;
    }

    public boolean HN() {
        return this.aIu;
    }
}
