package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder ajJ;
    private g ajK;
    private ArrayList<f> ajL;
    private u ajM;
    private d ajN;
    private e ajO;
    private int ajP;
    private int mType;

    public c() {
        this.mType = 0;
        this.ajJ = null;
        this.ajK = null;
        this.ajL = null;
        this.ajM = null;
        this.ajN = null;
    }

    public c(int i) {
        this.mType = 0;
        this.ajJ = null;
        this.ajK = null;
        this.ajL = null;
        this.ajM = null;
        this.ajN = null;
        this.mType = i;
        this.ajN = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> Ad() {
        if (this.ajL == null) {
            this.ajL = new ArrayList<>();
        }
        return this.ajL;
    }

    public void E(int i, int i2) {
        if (this.ajL != null) {
            Iterator<f> it = this.ajL.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.G(0, i2);
                }
            }
        }
    }

    public void F(int i, int i2) {
        if (this.ajL != null) {
            Iterator<f> it = this.ajL.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.ajJ == null) {
                this.ajJ = new SpannableStringBuilder("");
            }
            this.ajJ.append(charSequence);
            this.ajN.ajQ = this.ajJ.length();
        }
    }

    public void eH(String str) {
        if (this.mType == 32 && str != null) {
            this.ajJ = new SpannableStringBuilder(str);
        }
    }

    public g Ae() {
        if (this.mType != 8) {
            return null;
        }
        return this.ajK;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.ajK = gVar;
        }
    }

    public SpannableStringBuilder Af() {
        return this.ajJ;
    }

    public u Ag() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajM;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.ajM = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.ajJ != null) {
                return this.ajJ.toString();
            }
        } else if (this.mType == 8) {
            if (this.ajK != null) {
                return this.ajK.Am();
            }
        } else if (this.mType == 17 && this.ajO != null) {
            return this.ajO.aam.ZM;
        }
        return "";
    }

    public d Ah() {
        if (this.mType != 1) {
            return null;
        }
        return this.ajN;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.ajO = eVar;
        }
    }

    public e Ai() {
        return this.ajO;
    }

    public int Aj() {
        return this.ajP;
    }

    public void ed(int i) {
        this.ajP = i;
    }
}
