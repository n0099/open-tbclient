package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gnZ;
    private float[] goa;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gnZ = gVarArr;
        this.goa = new float[this.gnZ.length];
        for (int i = 0; i < this.gnZ.length; i++) {
            this.goa[i] = this.gnZ[i].getProgress();
        }
        this.mFactor = 1.0f / this.gnZ.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gnZ) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gnZ) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gnZ) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gnZ) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bOe() != null) {
            for (int i = 0; i < this.gnZ.length; i++) {
                if (gVar == this.gnZ[i]) {
                    this.goa[i] = f;
                }
            }
            bOe().a(this, bNK());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bOe() != null) {
            for (int i = 0; i < this.gnZ.length; i++) {
                if (gVar == this.gnZ[i]) {
                    this.goa[i] = 100.0f;
                    if (ud(i)) {
                        bOe().a(this);
                    } else {
                        bOe().a(this, bNK());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bOe() != null) {
            bOe().b(gVar);
        }
    }

    private float bNK() {
        float f = 0.0f;
        for (float f2 : this.goa) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean ud(int i) {
        for (int i2 = 0; i2 < this.gnZ.length; i2++) {
            if (i2 != i && !this.gnZ[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
