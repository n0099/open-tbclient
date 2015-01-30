package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder ajM;
    private g ajN;
    private ArrayList<f> ajO;
    private u ajP;
    private d ajQ;
    private e ajR;
    private int ajS;
    private int mType;

    public c() {
        this.mType = 0;
        this.ajM = null;
        this.ajN = null;
        this.ajO = null;
        this.ajP = null;
        this.ajQ = null;
    }

    public c(int i) {
        this.mType = 0;
        this.ajM = null;
        this.ajN = null;
        this.ajO = null;
        this.ajP = null;
        this.ajQ = null;
        this.mType = i;
        this.ajQ = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> Aj() {
        if (this.ajO == null) {
            this.ajO = new ArrayList<>();
        }
        return this.ajO;
    }

    public void E(int i, int i2) {
        if (this.ajO != null) {
            Iterator<f> it = this.ajO.iterator();
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
        if (this.ajO != null) {
            Iterator<f> it = this.ajO.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.ajM == null) {
                this.ajM = new SpannableStringBuilder("");
            }
            this.ajM.append(charSequence);
            this.ajQ.ajT = this.ajM.length();
        }
    }

    public void eK(String str) {
        if (this.mType == 32 && str != null) {
            this.ajM = new SpannableStringBuilder(str);
        }
    }

    public g Ak() {
        if (this.mType != 8) {
            return null;
        }
        return this.ajN;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.ajN = gVar;
        }
    }

    public SpannableStringBuilder Al() {
        return this.ajM;
    }

    public u Am() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ajP;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.ajP = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.ajM != null) {
                return this.ajM.toString();
            }
        } else if (this.mType == 8) {
            if (this.ajN != null) {
                return this.ajN.As();
            }
        } else if (this.mType == 17 && this.ajR != null) {
            return this.ajR.aap.ZP;
        }
        return "";
    }

    public d An() {
        if (this.mType != 1) {
            return null;
        }
        return this.ajQ;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.ajR = eVar;
        }
    }

    public e Ao() {
        return this.ajR;
    }

    public int Ap() {
        return this.ajS;
    }

    public void ed(int i) {
        this.ajS = i;
    }
}
