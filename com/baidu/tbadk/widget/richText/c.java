package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aCU;
    private f aCV;
    private ArrayList<e> aCW;
    private v aCX;
    private a aCY;
    private d aCZ;
    private m aDa;
    private k aDb;
    private j aDc;
    private int aDd;
    private int mType;

    public c() {
        this.mType = 0;
        this.aCU = null;
        this.aCV = null;
        this.aCW = null;
        this.aCX = null;
        this.aCY = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aCU = null;
        this.aCV = null;
        this.aCW = null;
        this.aCX = null;
        this.aCY = null;
        this.mType = i;
        this.aCY = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> FP() {
        if (this.aCW == null) {
            this.aCW = new ArrayList<>();
        }
        return this.aCW;
    }

    public void O(int i, int i2) {
        if (this.aCW != null) {
            Iterator<e> it = this.aCW.iterator();
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
        if (this.aCW != null) {
            Iterator<e> it = this.aCW.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aCU == null) {
                this.aCU = new SpannableStringBuilder("");
            }
            this.aCU.append(charSequence);
            this.aCY.aDe = this.aCU.length();
        }
    }

    public void setVideoUrl(String str) {
        if (this.mType == 32 && str != null) {
            this.aCU = new SpannableStringBuilder(str);
        }
    }

    public f FQ() {
        if (this.mType != 8) {
            return null;
        }
        return this.aCV;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aCV = fVar;
        }
    }

    public SpannableStringBuilder FR() {
        return this.aCU;
    }

    public v FS() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aCX;
        }
        return null;
    }

    public void a(v vVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aCX = vVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aCU != null) {
                return this.aCU.toString();
            }
        } else if (this.mType == 8) {
            if (this.aCV != null) {
                return this.aCV.Gb();
            }
        } else if (this.mType == 17 && this.aCZ != null) {
            return this.aCZ.auv.atV;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aDe = 0;
        public int aDf = 0;
        public int aDg = 0;
        public boolean aDh;

        public a() {
        }
    }

    public a FT() {
        if (this.mType != 1) {
            return null;
        }
        return this.aCY;
    }

    public void a(m mVar) {
        if (this.mType == 32) {
            this.aDa = mVar;
        }
    }

    public m FU() {
        if (this.mType != 32) {
            return null;
        }
        return this.aDa;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aCZ = dVar;
        }
    }

    public d FV() {
        return this.aCZ;
    }

    public int FW() {
        return this.aDd;
    }

    public void eV(int i) {
        this.aDd = i;
    }

    public k FX() {
        if (this.mType != 1280) {
            return null;
        }
        return this.aDb;
    }

    public void a(k kVar) {
        this.aDb = kVar;
    }

    public j FY() {
        return this.aDc;
    }

    public void a(j jVar) {
        this.aDc = jVar;
    }
}
