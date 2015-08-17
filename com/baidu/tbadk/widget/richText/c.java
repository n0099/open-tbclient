package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder aBj;
    private f aBk;
    private ArrayList<e> aBl;
    private r aBm;
    private a aBn;
    private d aBo;
    private j aBp;
    private int aBq;
    private int mType;

    public c() {
        this.mType = 0;
        this.aBj = null;
        this.aBk = null;
        this.aBl = null;
        this.aBm = null;
        this.aBn = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aBj = null;
        this.aBk = null;
        this.aBl = null;
        this.aBm = null;
        this.aBn = null;
        this.mType = i;
        this.aBn = new a();
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<e> Fa() {
        if (this.aBl == null) {
            this.aBl = new ArrayList<>();
        }
        return this.aBl;
    }

    public void N(int i, int i2) {
        if (this.aBl != null) {
            Iterator<e> it = this.aBl.iterator();
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
        if (this.aBl != null) {
            Iterator<e> it = this.aBl.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aBj == null) {
                this.aBj = new SpannableStringBuilder("");
            }
            this.aBj.append(charSequence);
            this.aBn.aBr = this.aBj.length();
        }
    }

    public void fD(String str) {
        if (this.mType == 32 && str != null) {
            this.aBj = new SpannableStringBuilder(str);
        }
    }

    public f Fb() {
        if (this.mType != 8) {
            return null;
        }
        return this.aBk;
    }

    public void a(f fVar) {
        if (this.mType == 8) {
            this.aBk = fVar;
        }
    }

    public SpannableStringBuilder Fc() {
        return this.aBj;
    }

    public r Fd() {
        if (this.mType == 512 || this.mType == 768) {
            return this.aBm;
        }
        return null;
    }

    public void a(r rVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.aBm = rVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aBj != null) {
                return this.aBj.toString();
            }
        } else if (this.mType == 8) {
            if (this.aBk != null) {
                return this.aBk.Fk();
            }
        } else if (this.mType == 17 && this.aBo != null) {
            return this.aBo.atx.asY;
        }
        return "";
    }

    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.lib.a.b.a.a.i {
        public int aBr = 0;
        public int aBs = 0;
        public int aBt = 0;
        public boolean aBu;

        public a() {
        }
    }

    public a Fe() {
        if (this.mType != 1) {
            return null;
        }
        return this.aBn;
    }

    public void a(j jVar) {
        if (this.mType == 32) {
            this.aBp = jVar;
        }
    }

    public j Ff() {
        if (this.mType != 32) {
            return null;
        }
        return this.aBp;
    }

    public void a(d dVar) {
        if (this.mType == 17) {
            this.aBo = dVar;
        }
    }

    public d Fg() {
        return this.aBo;
    }

    public int Fh() {
        return this.aBq;
    }

    public void ey(int i) {
        this.aBq = i;
    }
}
