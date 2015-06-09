package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder atW;
    private g atX;
    private ArrayList<f> atY;
    private u atZ;
    private d aua;
    private e aub;
    private int auc;
    private int mType;

    public c() {
        this.mType = 0;
        this.atW = null;
        this.atX = null;
        this.atY = null;
        this.atZ = null;
        this.aua = null;
    }

    public c(int i) {
        this.mType = 0;
        this.atW = null;
        this.atX = null;
        this.atY = null;
        this.atZ = null;
        this.aua = null;
        this.mType = i;
        this.aua = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> Eq() {
        if (this.atY == null) {
            this.atY = new ArrayList<>();
        }
        return this.atY;
    }

    public void D(int i, int i2) {
        if (this.atY != null) {
            Iterator<f> it = this.atY.iterator();
            while (it.hasNext()) {
                f next = it.next();
                Rect bounds = next.getBounds();
                if (bounds != null && i > bounds.bottom - bounds.top) {
                    next.F(0, i2);
                }
            }
        }
    }

    public void E(int i, int i2) {
        if (this.atY != null) {
            Iterator<f> it = this.atY.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.atW == null) {
                this.atW = new SpannableStringBuilder("");
            }
            this.atW.append(charSequence);
            this.aua.aud = this.atW.length();
        }
    }

    public void fk(String str) {
        if (this.mType == 32 && str != null) {
            this.atW = new SpannableStringBuilder(str);
        }
    }

    public g Er() {
        if (this.mType != 8) {
            return null;
        }
        return this.atX;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.atX = gVar;
        }
    }

    public SpannableStringBuilder Es() {
        return this.atW;
    }

    public u Et() {
        if (this.mType == 512 || this.mType == 768) {
            return this.atZ;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.atZ = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.atW != null) {
                return this.atW.toString();
            }
        } else if (this.mType == 8) {
            if (this.atX != null) {
                return this.atX.Ez();
            }
        } else if (this.mType == 17 && this.aub != null) {
            return this.aub.alT.alt;
        }
        return "";
    }

    public d Eu() {
        if (this.mType != 1) {
            return null;
        }
        return this.aua;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.aub = eVar;
        }
    }

    public e Ev() {
        return this.aub;
    }

    public int Ew() {
        return this.auc;
    }

    public void et(int i) {
        this.auc = i;
    }
}
