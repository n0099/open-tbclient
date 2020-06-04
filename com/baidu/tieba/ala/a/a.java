package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public class a extends g implements h {
    private g[] fmC;
    private float[] fmD;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fmC = gVarArr;
        this.fmD = new float[this.fmC.length];
        for (int i = 0; i < this.fmC.length; i++) {
            this.fmD[i] = this.fmC[i].getProgress();
        }
        this.mFactor = 1.0f / this.fmC.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fmC) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fmC) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fmC) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        for (g gVar : this.fmC) {
            if (!gVar.gt()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bsB() != null) {
            for (int i = 0; i < this.fmC.length; i++) {
                if (gVar == this.fmC[i]) {
                    this.fmD[i] = f;
                }
            }
            bsB().a(this, bsk());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bsB() != null) {
            for (int i = 0; i < this.fmC.length; i++) {
                if (gVar == this.fmC[i]) {
                    this.fmD[i] = 100.0f;
                    if (pU(i)) {
                        bsB().a(this);
                    } else {
                        bsB().a(this, bsk());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bsB() != null) {
            bsB().b(gVar);
        }
    }

    private float bsk() {
        float f = 0.0f;
        for (float f2 : this.fmD) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean pU(int i) {
        for (int i2 = 0; i2 < this.fmC.length; i2++) {
            if (i2 != i && !this.fmC[i2].gt()) {
                return false;
            }
        }
        return true;
    }
}
