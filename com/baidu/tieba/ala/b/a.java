package com.baidu.tieba.ala.b;
/* loaded from: classes10.dex */
public class a extends g implements h {
    private g[] gMe;
    private float[] gMf;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gMe = gVarArr;
        this.gMf = new float[this.gMe.length];
        for (int i = 0; i < this.gMe.length; i++) {
            this.gMf[i] = this.gMe[i].getProgress();
        }
        this.mFactor = 1.0f / this.gMe.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gMe) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gMe) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gMe) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        for (g gVar : this.gMe) {
            if (!gVar.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bTg() != null) {
            for (int i = 0; i < this.gMe.length; i++) {
                if (gVar == this.gMe[i]) {
                    this.gMf[i] = f;
                }
            }
            bTg().a(this, bSO());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bTg() != null) {
            for (int i = 0; i < this.gMe.length; i++) {
                if (gVar == this.gMe[i]) {
                    this.gMf[i] = 100.0f;
                    if (ud(i)) {
                        bTg().a(this);
                    } else {
                        bTg().a(this, bSO());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bTg() != null) {
            bTg().b(gVar);
        }
    }

    private float bSO() {
        float f = 0.0f;
        for (float f2 : this.gMf) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean ud(int i) {
        for (int i2 = 0; i2 < this.gMe.length; i2++) {
            if (i2 != i && !this.gMe[i2].isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
