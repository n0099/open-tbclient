package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public class a extends g implements h {
    private g[] gNQ;
    private float[] gNR;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gNQ = gVarArr;
        this.gNR = new float[this.gNQ.length];
        for (int i = 0; i < this.gNQ.length; i++) {
            this.gNR[i] = this.gNQ[i].getProgress();
        }
        this.mFactor = 1.0f / this.gNQ.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gNQ) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gNQ) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gNQ) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        for (g gVar : this.gNQ) {
            if (!gVar.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bWn() != null) {
            for (int i = 0; i < this.gNQ.length; i++) {
                if (gVar == this.gNQ[i]) {
                    this.gNR[i] = f;
                }
            }
            bWn().a(this, bVV());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bWn() != null) {
            for (int i = 0; i < this.gNQ.length; i++) {
                if (gVar == this.gNQ[i]) {
                    this.gNR[i] = 100.0f;
                    if (vD(i)) {
                        bWn().a(this);
                    } else {
                        bWn().a(this, bVV());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bWn() != null) {
            bWn().b(gVar);
        }
    }

    private float bVV() {
        float f = 0.0f;
        for (float f2 : this.gNR) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean vD(int i) {
        for (int i2 = 0; i2 < this.gNQ.length; i2++) {
            if (i2 != i && !this.gNQ[i2].isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
