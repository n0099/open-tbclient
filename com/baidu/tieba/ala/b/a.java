package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gCe;
    private float[] gCf;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gCe = gVarArr;
        this.gCf = new float[this.gCe.length];
        for (int i = 0; i < this.gCe.length; i++) {
            this.gCf[i] = this.gCe[i].getProgress();
        }
        this.mFactor = 1.0f / this.gCe.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gCe) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gCe) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gCe) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gCe) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bTI() != null) {
            for (int i = 0; i < this.gCe.length; i++) {
                if (gVar == this.gCe[i]) {
                    this.gCf[i] = f;
                }
            }
            bTI().a(this, bTq());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bTI() != null) {
            for (int i = 0; i < this.gCe.length; i++) {
                if (gVar == this.gCe[i]) {
                    this.gCf[i] = 100.0f;
                    if (vs(i)) {
                        bTI().a(this);
                    } else {
                        bTI().a(this, bTq());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bTI() != null) {
            bTI().b(gVar);
        }
    }

    private float bTq() {
        float f = 0.0f;
        for (float f2 : this.gCf) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean vs(int i) {
        for (int i2 = 0; i2 < this.gCe.length; i2++) {
            if (i2 != i && !this.gCe[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
