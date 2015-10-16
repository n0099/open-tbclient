package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private d aBA;
    private j aBB;
    private int aBC;
    private SpannableStringBuilder aBv;
    private f aBw;
    private ArrayList<e> aBx;
    private r aBy;
    private a aBz;
    private int mType;

    public c() {
        this.mType = 0;
        this.aBv = null;
        this.aBw = null;
        this.aBx = null;
        this.aBy = null;
        this.aBz = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aBv = null;
        this.aBw = null;
        this.aBx = null;
        this.aBy = null;
        this.aBz = null;
        this.mType = i;
        this.aBz = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> EX() {
        if (this.aBx == null) {
            this.aBx = new ArrayList<>();
        }
        return this.aBx;
    }

    public void N(int i, int i2) {
        if (this.aBx != null) {
            Iterator<e> it = this.aBx.iterator();
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
        if (this.aBx != null) {
            Iterator<e> it = this.aBx.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aBv == null) {
                this.aBv = new SpannableStringBuilder("");
            }
            this.aBv.append(charSequence);
            this.aBz.aBD = this.aBv.length();
        }
    }

    public void fP(String str) {
        if (this.mType == 32 && str != null) {
            this.aBv = new SpannableStringBuilder(str);
        }
    }

    public f EY() {
        if (this.mType != 8) {
            return null;
        }
        return this.aBw;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aBw = fVar;
        }
    }

    public SpannableStringBuilder EZ() {
        return this.aBv;
    }

    public r Fa() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aBy;
        }
        return null;
    }

    public void a(r rVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aBy = rVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aBv != null) {
                return this.aBv.toString();
            }
        } else if (this.mType == 8) {
            if (this.aBw != null) {
                return this.aBw.Fh();
            }
        } else if (this.mType == 17 && this.aBA != null) {
            return this.aBA.atF.atg;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aBD = 0;
        public int aBE = 0;
        public int aBF = 0;
        public boolean aBG;

        public a() {
        }
    }

    public a Fb() {
        if (this.mType != 1) {
            return null;
        }
        return this.aBz;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.aBB = jVar;
        }
    }

    public j Fc() {
        if (this.mType != 32) {
            return null;
        }
        return this.aBB;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aBA = dVar;
        }
    }

    public d Fd() {
        return this.aBA;
    }

    public int Fe() {
        return this.aBC;
    }

    public void eJ(int i) {
        this.aBC = i;
    }
}
