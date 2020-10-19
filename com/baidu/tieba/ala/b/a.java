package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gdV;
    private float[] gdW;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gdV = gVarArr;
        this.gdW = new float[this.gdV.length];
        for (int i = 0; i < this.gdV.length; i++) {
            this.gdW[i] = this.gdV[i].getProgress();
        }
        this.mFactor = 1.0f / this.gdV.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gdV) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gdV) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gdV) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gdV) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bLC() != null) {
            for (int i = 0; i < this.gdV.length; i++) {
                if (gVar == this.gdV[i]) {
                    this.gdW[i] = f;
                }
            }
            bLC().a(this, bLi());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bLC() != null) {
            for (int i = 0; i < this.gdV.length; i++) {
                if (gVar == this.gdV[i]) {
                    this.gdW[i] = 100.0f;
                    if (tK(i)) {
                        bLC().a(this);
                    } else {
                        bLC().a(this, bLi());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bLC() != null) {
            bLC().b(gVar);
        }
    }

    private float bLi() {
        float f = 0.0f;
        for (float f2 : this.gdW) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean tK(int i) {
        for (int i2 = 0; i2 < this.gdV.length; i2++) {
            if (i2 != i && !this.gdV[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
