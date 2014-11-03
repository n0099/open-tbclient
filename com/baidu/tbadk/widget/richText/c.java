package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private ArrayList<f> abA;
    private u abB;
    private d abC;
    private e abD;
    private int abE;
    private SpannableStringBuilder aby;
    private g abz;
    private int mType;

    public c() {
        this.mType = 0;
        this.aby = null;
        this.abz = null;
        this.abA = null;
        this.abB = null;
        this.abC = null;
    }

    public c(int i) {
        this.mType = 0;
        this.aby = null;
        this.abz = null;
        this.abA = null;
        this.abB = null;
        this.abC = null;
        this.mType = i;
        this.abC = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> vE() {
        if (this.abA == null) {
            this.abA = new ArrayList<>();
        }
        return this.abA;
    }

    public void A(int i, int i2) {
        if (this.abA != null) {
            Iterator<f> it = this.abA.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.C(0, i2);
                }
            }
        }
    }

    public void B(int i, int i2) {
        if (this.abA != null) {
            Iterator<f> it = this.abA.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.aby == null) {
                this.aby = new SpannableStringBuilder("");
            }
            this.aby.append(charSequence);
            this.abC.abF = this.aby.length();
        }
    }

    public void dQ(String str) {
        if (this.mType == 32 && str != null) {
            this.aby = new SpannableStringBuilder(str);
        }
    }

    public g vF() {
        if (this.mType != 8) {
            return null;
        }
        return this.abz;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.abz = gVar;
        }
    }

    public SpannableStringBuilder vG() {
        return this.aby;
    }

    public u vH() {
        if (this.mType == 512 || this.mType == 768) {
            return this.abB;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.abB = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.aby != null) {
                return this.aby.toString();
            }
        } else if (this.mType == 8) {
            if (this.abz != null) {
                return this.abz.vN();
            }
        } else if (this.mType == 17 && this.abD != null) {
            return this.abD.TJ.Tj;
        }
        return "";
    }

    public d vI() {
        if (this.mType != 1) {
            return null;
        }
        return this.abC;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.abD = eVar;
        }
    }

    public e vJ() {
        return this.abD;
    }

    public int vK() {
        return this.abE;
    }

    public void du(int i) {
        this.abE = i;
    }
}
