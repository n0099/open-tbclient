package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public class a extends g implements h {
    private g[] fmr;
    private float[] fms;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fmr = gVarArr;
        this.fms = new float[this.fmr.length];
        for (int i = 0; i < this.fmr.length; i++) {
            this.fms[i] = this.fmr[i].getProgress();
        }
        this.mFactor = 1.0f / this.fmr.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fmr) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fmr) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fmr) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        for (g gVar : this.fmr) {
            if (!gVar.gt()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bsz() != null) {
            for (int i = 0; i < this.fmr.length; i++) {
                if (gVar == this.fmr[i]) {
                    this.fms[i] = f;
                }
            }
            bsz().a(this, bsi());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bsz() != null) {
            for (int i = 0; i < this.fmr.length; i++) {
                if (gVar == this.fmr[i]) {
                    this.fms[i] = 100.0f;
                    if (pS(i)) {
                        bsz().a(this);
                    } else {
                        bsz().a(this, bsi());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bsz() != null) {
            bsz().b(gVar);
        }
    }

    private float bsi() {
        float f = 0.0f;
        for (float f2 : this.fms) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean pS(int i) {
        for (int i2 = 0; i2 < this.fmr.length; i2++) {
            if (i2 != i && !this.fmr[i2].gt()) {
                return false;
            }
        }
        return true;
    }
}
