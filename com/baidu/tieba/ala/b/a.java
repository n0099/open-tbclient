package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public class a extends g implements h {
    private g[] gLQ;
    private float[] gLR;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gLQ = gVarArr;
        this.gLR = new float[this.gLQ.length];
        for (int i = 0; i < this.gLQ.length; i++) {
            this.gLR[i] = this.gLQ[i].getProgress();
        }
        this.mFactor = 1.0f / this.gLQ.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gLQ) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gLQ) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gLQ) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        for (g gVar : this.gLQ) {
            if (!gVar.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bSZ() != null) {
            for (int i = 0; i < this.gLQ.length; i++) {
                if (gVar == this.gLQ[i]) {
                    this.gLR[i] = f;
                }
            }
            bSZ().a(this, bSH());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bSZ() != null) {
            for (int i = 0; i < this.gLQ.length; i++) {
                if (gVar == this.gLQ[i]) {
                    this.gLR[i] = 100.0f;
                    if (ud(i)) {
                        bSZ().a(this);
                    } else {
                        bSZ().a(this, bSH());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bSZ() != null) {
            bSZ().b(gVar);
        }
    }

    private float bSH() {
        float f = 0.0f;
        for (float f2 : this.gLR) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean ud(int i) {
        for (int i2 = 0; i2 < this.gLQ.length; i2++) {
            if (i2 != i && !this.gLQ[i2].isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
