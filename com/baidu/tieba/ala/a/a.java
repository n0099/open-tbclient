package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public class a extends g implements h {
    private g[] fxQ;
    private float[] fxR;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fxQ = gVarArr;
        this.fxR = new float[this.fxQ.length];
        for (int i = 0; i < this.fxQ.length; i++) {
            this.fxR[i] = this.fxQ[i].getProgress();
        }
        this.mFactor = 1.0f / this.fxQ.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fxQ) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fxQ) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fxQ) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gJ() {
        for (g gVar : this.fxQ) {
            if (!gVar.gJ()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bvx() != null) {
            for (int i = 0; i < this.fxQ.length; i++) {
                if (gVar == this.fxQ[i]) {
                    this.fxR[i] = f;
                }
            }
            bvx().a(this, bvg());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bvx() != null) {
            for (int i = 0; i < this.fxQ.length; i++) {
                if (gVar == this.fxQ[i]) {
                    this.fxR[i] = 100.0f;
                    if (qt(i)) {
                        bvx().a(this);
                    } else {
                        bvx().a(this, bvg());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bvx() != null) {
            bvx().b(gVar);
        }
    }

    private float bvg() {
        float f = 0.0f;
        for (float f2 : this.fxR) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean qt(int i) {
        for (int i2 = 0; i2 < this.fxQ.length; i2++) {
            if (i2 != i && !this.fxQ[i2].gJ()) {
                return false;
            }
        }
        return true;
    }
}
