package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aBk;
    private f aBl;
    private ArrayList<e> aBm;
    private r aBn;
    private a aBo;
    private d aBp;
    private j aBq;
    private int aBr;
    private int mType;

    public c() {
        this.mType = 0;
        this.aBk = null;
        this.aBl = null;
        this.aBm = null;
        this.aBn = null;
        this.aBo = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aBk = null;
        this.aBl = null;
        this.aBm = null;
        this.aBn = null;
        this.aBo = null;
        this.mType = i;
        this.aBo = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> EX() {
        if (this.aBm == null) {
            this.aBm = new ArrayList<>();
        }
        return this.aBm;
    }

    public void N(int i, int i2) {
        if (this.aBm != null) {
            Iterator<e> it = this.aBm.iterator();
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
        if (this.aBm != null) {
            Iterator<e> it = this.aBm.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aBk == null) {
                this.aBk = new SpannableStringBuilder("");
            }
            this.aBk.append(charSequence);
            this.aBo.aBs = this.aBk.length();
        }
    }

    public void fP(String str) {
        if (this.mType == 32 && str != null) {
            this.aBk = new SpannableStringBuilder(str);
        }
    }

    public f EY() {
        if (this.mType != 8) {
            return null;
        }
        return this.aBl;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aBl = fVar;
        }
    }

    public SpannableStringBuilder EZ() {
        return this.aBk;
    }

    public r Fa() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aBn;
        }
        return null;
    }

    public void a(r rVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aBn = rVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aBk != null) {
                return this.aBk.toString();
            }
        } else if (this.mType == 8) {
            if (this.aBl != null) {
                return this.aBl.Fh();
            }
        } else if (this.mType == 17 && this.aBp != null) {
            return this.aBp.atE.atf;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aBs = 0;
        public int aBt = 0;
        public int aBu = 0;
        public boolean aBv;

        public a() {
        }
    }

    public a Fb() {
        if (this.mType != 1) {
            return null;
        }
        return this.aBo;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.aBq = jVar;
        }
    }

    public j Fc() {
        if (this.mType != 32) {
            return null;
        }
        return this.aBq;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aBp = dVar;
        }
    }

    public d Fd() {
        return this.aBp;
    }

    public int Fe() {
        return this.aBr;
    }

    public void eJ(int i) {
        this.aBr = i;
    }
}
