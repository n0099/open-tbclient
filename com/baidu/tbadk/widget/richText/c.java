package com.baidu.tbadk.widget.richText;

import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    private SpannableStringBuilder asi;
    private g asj;
    private ArrayList<f> ask;
    private u asl;
    private d asm;
    private e asn;
    private int aso;
    private int mType;

    public c() {
        this.mType = 0;
        this.asi = null;
        this.asj = null;
        this.ask = null;
        this.asl = null;
        this.asm = null;
    }

    public c(int i) {
        this.mType = 0;
        this.asi = null;
        this.asj = null;
        this.ask = null;
        this.asl = null;
        this.asm = null;
        this.mType = i;
        this.asm = new d(this);
    }

    public int getType() {
        return this.mType;
    }

    public ArrayList<f> Dz() {
        if (this.ask == null) {
            this.ask = new ArrayList<>();
        }
        return this.ask;
    }

    public void C(int i, int i2) {
        if (this.ask != null) {
            Iterator<f> it = this.ask.iterator();
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
        if (this.ask != null) {
            Iterator<f> it = this.ask.iterator();
            while (it.hasNext()) {
                it.next().setBounds(0, 0, i, i2);
            }
        }
    }

    public void append(CharSequence charSequence) {
        if ((this.mType == 1 || this.mType == 768) && charSequence != null) {
            if (this.asi == null) {
                this.asi = new SpannableStringBuilder("");
            }
            this.asi.append(charSequence);
            this.asm.asp = this.asi.length();
        }
    }

    public void eM(String str) {
        if (this.mType == 32 && str != null) {
            this.asi = new SpannableStringBuilder(str);
        }
    }

    public g DA() {
        if (this.mType != 8) {
            return null;
        }
        return this.asj;
    }

    public void a(g gVar) {
        if (this.mType == 8) {
            this.asj = gVar;
        }
    }

    public SpannableStringBuilder DB() {
        return this.asi;
    }

    public u DC() {
        if (this.mType == 512 || this.mType == 768) {
            return this.asl;
        }
        return null;
    }

    public void a(u uVar) {
        if (this.mType == 512 || this.mType == 768) {
            this.asl = uVar;
        }
    }

    public String toString() {
        if (this.mType == 1) {
            if (this.asi != null) {
                return this.asi.toString();
            }
        } else if (this.mType == 8) {
            if (this.asj != null) {
                return this.asj.DI();
            }
        } else if (this.mType == 17 && this.asn != null) {
            return this.asn.akK.akk;
        }
        return "";
    }

    public d DD() {
        if (this.mType != 1) {
            return null;
        }
        return this.asm;
    }

    public void a(e eVar) {
        if (this.mType == 17) {
            this.asn = eVar;
        }
    }

    public e DE() {
        return this.asn;
    }

    public int DF() {
        return this.aso;
    }

    public void eh(int i) {
        this.aso = i;
    }
}
