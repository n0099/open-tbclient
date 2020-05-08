package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public class a extends g implements h {
    private g[] eZH;
    private float[] eZI;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.eZH = gVarArr;
        this.eZI = new float[this.eZH.length];
        for (int i = 0; i < this.eZH.length; i++) {
            this.eZI[i] = this.eZH[i].getProgress();
        }
        this.mFactor = 1.0f / this.eZH.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.eZH) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.eZH) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.eZH) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        for (g gVar : this.eZH) {
            if (!gVar.gt()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bnb() != null) {
            for (int i = 0; i < this.eZH.length; i++) {
                if (gVar == this.eZH[i]) {
                    this.eZI[i] = f;
                }
            }
            bnb().a(this, bmK());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bnb() != null) {
            for (int i = 0; i < this.eZH.length; i++) {
                if (gVar == this.eZH[i]) {
                    this.eZI[i] = 100.0f;
                    if (ps(i)) {
                        bnb().a(this);
                    } else {
                        bnb().a(this, bmK());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bnb() != null) {
            bnb().b(gVar);
        }
    }

    private float bmK() {
        float f = 0.0f;
        for (float f2 : this.eZI) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean ps(int i) {
        for (int i2 = 0; i2 < this.eZH.length; i2++) {
            if (i2 != i && !this.eZH[i2].gt()) {
                return false;
            }
        }
        return true;
    }
}
