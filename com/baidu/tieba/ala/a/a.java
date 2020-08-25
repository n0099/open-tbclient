package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] fOo;
    private float[] fOp;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fOo = gVarArr;
        this.fOp = new float[this.fOo.length];
        for (int i = 0; i < this.fOo.length; i++) {
            this.fOp[i] = this.fOo[i].getProgress();
        }
        this.mFactor = 1.0f / this.fOo.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fOo) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fOo) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fOo) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean ij() {
        for (g gVar : this.fOo) {
            if (!gVar.ij()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bHJ() != null) {
            for (int i = 0; i < this.fOo.length; i++) {
                if (gVar == this.fOo[i]) {
                    this.fOp[i] = f;
                }
            }
            bHJ().a(this, bHp());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bHJ() != null) {
            for (int i = 0; i < this.fOo.length; i++) {
                if (gVar == this.fOo[i]) {
                    this.fOp[i] = 100.0f;
                    if (sU(i)) {
                        bHJ().a(this);
                    } else {
                        bHJ().a(this, bHp());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bHJ() != null) {
            bHJ().b(gVar);
        }
    }

    private float bHp() {
        float f = 0.0f;
        for (float f2 : this.fOp) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean sU(int i) {
        for (int i2 = 0; i2 < this.fOo.length; i2++) {
            if (i2 != i && !this.fOo[i2].ij()) {
                return false;
            }
        }
        return true;
    }
}
