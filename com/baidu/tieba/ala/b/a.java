package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] fRD;
    private float[] fRE;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fRD = gVarArr;
        this.fRE = new float[this.fRD.length];
        for (int i = 0; i < this.fRD.length; i++) {
            this.fRE[i] = this.fRD[i].getProgress();
        }
        this.mFactor = 1.0f / this.fRD.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.fRD) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.fRD) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fRD) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ij() {
        for (g gVar : this.fRD) {
            if (!gVar.ij()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bIS() != null) {
            for (int i = 0; i < this.fRD.length; i++) {
                if (gVar == this.fRD[i]) {
                    this.fRE[i] = f;
                }
            }
            bIS().a(this, bIy());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bIS() != null) {
            for (int i = 0; i < this.fRD.length; i++) {
                if (gVar == this.fRD[i]) {
                    this.fRE[i] = 100.0f;
                    if (tm(i)) {
                        bIS().a(this);
                    } else {
                        bIS().a(this, bIy());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bIS() != null) {
            bIS().b(gVar);
        }
    }

    private float bIy() {
        float f = 0.0f;
        for (float f2 : this.fRE) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean tm(int i) {
        for (int i2 = 0; i2 < this.fRD.length; i2++) {
            if (i2 != i && !this.fRD[i2].ij()) {
                return false;
            }
        }
        return true;
    }
}
