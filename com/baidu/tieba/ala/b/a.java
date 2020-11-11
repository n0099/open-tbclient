package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gtM;
    private float[] gtN;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gtM = gVarArr;
        this.gtN = new float[this.gtM.length];
        for (int i = 0; i < this.gtM.length; i++) {
            this.gtN[i] = this.gtM[i].getProgress();
        }
        this.mFactor = 1.0f / this.gtM.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gtM) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gtM) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gtM) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gtM) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bQE() != null) {
            for (int i = 0; i < this.gtM.length; i++) {
                if (gVar == this.gtM[i]) {
                    this.gtN[i] = f;
                }
            }
            bQE().a(this, bQk());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bQE() != null) {
            for (int i = 0; i < this.gtM.length; i++) {
                if (gVar == this.gtM[i]) {
                    this.gtN[i] = 100.0f;
                    if (un(i)) {
                        bQE().a(this);
                    } else {
                        bQE().a(this, bQk());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bQE() != null) {
            bQE().b(gVar);
        }
    }

    private float bQk() {
        float f = 0.0f;
        for (float f2 : this.gtN) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean un(int i) {
        for (int i2 = 0; i2 < this.gtM.length; i2++) {
            if (i2 != i && !this.gtM[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
