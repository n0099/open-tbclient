package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gCc;
    private float[] gCd;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gCc = gVarArr;
        this.gCd = new float[this.gCc.length];
        for (int i = 0; i < this.gCc.length; i++) {
            this.gCd[i] = this.gCc[i].getProgress();
        }
        this.mFactor = 1.0f / this.gCc.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gCc) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gCc) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gCc) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gCc) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bTH() != null) {
            for (int i = 0; i < this.gCc.length; i++) {
                if (gVar == this.gCc[i]) {
                    this.gCd[i] = f;
                }
            }
            bTH().a(this, bTp());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bTH() != null) {
            for (int i = 0; i < this.gCc.length; i++) {
                if (gVar == this.gCc[i]) {
                    this.gCd[i] = 100.0f;
                    if (vs(i)) {
                        bTH().a(this);
                    } else {
                        bTH().a(this, bTp());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bTH() != null) {
            bTH().b(gVar);
        }
    }

    private float bTp() {
        float f = 0.0f;
        for (float f2 : this.gCd) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean vs(int i) {
        for (int i2 = 0; i2 < this.gCc.length; i2++) {
            if (i2 != i && !this.gCc[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
