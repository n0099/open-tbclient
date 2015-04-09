package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder asq;
    private g asr;
    private ArrayList<f> ass;
    private u ast;
    private d asu;
    private e asv;
    private int asw;
    private int mType;

    public c() {
        this.mType = 0;
        this.asq = null;
        this.asr = null;
        this.ass = null;
        this.ast = null;
        this.asu = null;
    }

    public c(int i) {
        this.mType = 0;
        this.asq = null;
        this.asr = null;
        this.ass = null;
        this.ast = null;
        this.asu = null;
        this.mType = i;
        this.asu = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> DF() {
        if (this.ass == null) {
            this.ass = new ArrayList<>();
        }
        return this.ass;
    }

    public void C(int i, int i2) {
        if (this.ass != null) {
            Iterator<f> it = this.ass.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.E(0, i2);
                }
            }
        }
    }

    public void D(int i, int i2) {
        if (this.ass != null) {
            Iterator<f> it = this.ass.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.asq == null) {
                this.asq = new SpannableStringBuilder("");
            }
            this.asq.append(charSequence);
            this.asu.asx = this.asq.length();
        }
    }

    public void eP(String str) {
        if (this.mType == 32 && str != null) {
            this.asq = new SpannableStringBuilder(str);
        }
    }

    public g DG() {
        if (this.mType != 8) {
            return null;
        }
        return this.asr;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.asr = gVar;
        }
    }

    public SpannableStringBuilder DH() {
        return this.asq;
    }

    public u DI() {
        if (this.mType == 512 || this.mType == 768) {
            return this.ast;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.ast = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.asq != null) {
                return this.asq.toString();
            }
        } else if (this.mType == 8) {
            if (this.asr != null) {
                return this.asr.DO();
            }
        } else if (this.mType == 17 && this.asv != null) {
            return this.asv.akS.aks;
        }
        return "";
    }

    public d DJ() {
        if (this.mType != 1) {
            return null;
        }
        return this.asu;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.asv = eVar;
        }
    }

    public e DK() {
        return this.asv;
    }

    public int DL() {
        return this.asw;
    }

    public void eh(int i) {
        this.asw = i;
    }
}
