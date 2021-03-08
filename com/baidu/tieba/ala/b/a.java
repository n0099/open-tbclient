package com.baidu.tieba.ala.b;
/* loaded from: classes9.dex */
public class a extends g implements h {
    private g[] gNN;
    private float[] gNO;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gNN = gVarArr;
        this.gNO = new float[this.gNN.length];
        for (int i = 0; i < this.gNN.length; i++) {
            this.gNO[i] = this.gNN[i].getProgress();
        }
        this.mFactor = 1.0f / this.gNN.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gNN) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gNN) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gNN) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        for (g gVar : this.gNN) {
            if (!gVar.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bTm() != null) {
            for (int i = 0; i < this.gNN.length; i++) {
                if (gVar == this.gNN[i]) {
                    this.gNO[i] = f;
                }
            }
            bTm().a(this, bSU());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bTm() != null) {
            for (int i = 0; i < this.gNN.length; i++) {
                if (gVar == this.gNN[i]) {
                    this.gNO[i] = 100.0f;
                    if (uf(i)) {
                        bTm().a(this);
                    } else {
                        bTm().a(this, bSU());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bTm() != null) {
            bTm().b(gVar);
        }
    }

    private float bSU() {
        float f = 0.0f;
        for (float f2 : this.gNO) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean uf(int i) {
        for (int i2 = 0; i2 < this.gNN.length; i2++) {
            if (i2 != i && !this.gNN[i2].isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
