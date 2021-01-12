package com.baidu.tieba.ala.b;
/* loaded from: classes9.dex */
public class a extends g implements h {
    private g[] gJk;
    private float[] gJl;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gJk = gVarArr;
        this.gJl = new float[this.gJk.length];
        for (int i = 0; i < this.gJk.length; i++) {
            this.gJl[i] = this.gJk[i].getProgress();
        }
        this.mFactor = 1.0f / this.gJk.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gJk) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gJk) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gJk) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean isCompleted() {
        for (g gVar : this.gJk) {
            if (!gVar.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bSw() != null) {
            for (int i = 0; i < this.gJk.length; i++) {
                if (gVar == this.gJk[i]) {
                    this.gJl[i] = f;
                }
            }
            bSw().a(this, bSe());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bSw() != null) {
            for (int i = 0; i < this.gJk.length; i++) {
                if (gVar == this.gJk[i]) {
                    this.gJl[i] = 100.0f;
                    if (tX(i)) {
                        bSw().a(this);
                    } else {
                        bSw().a(this, bSe());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bSw() != null) {
            bSw().b(gVar);
        }
    }

    private float bSe() {
        float f = 0.0f;
        for (float f2 : this.gJl) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean tX(int i) {
        for (int i2 = 0; i2 < this.gJk.length; i2++) {
            if (i2 != i && !this.gJk[i2].isCompleted()) {
                return false;
            }
        }
        return true;
    }
}
