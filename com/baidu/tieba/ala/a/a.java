package com.baidu.tieba.ala.a;
/* loaded from: classes3.dex */
public class a extends g implements h {
    private g[] eZC;
    private float[] eZD;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.eZC = gVarArr;
        this.eZD = new float[this.eZC.length];
        for (int i = 0; i < this.eZC.length; i++) {
            this.eZD[i] = this.eZC[i].getProgress();
        }
        this.mFactor = 1.0f / this.eZC.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.eZC) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.eZC) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.eZC) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gt() {
        for (g gVar : this.eZC) {
            if (!gVar.gt()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bnd() != null) {
            for (int i = 0; i < this.eZC.length; i++) {
                if (gVar == this.eZC[i]) {
                    this.eZD[i] = f;
                }
            }
            bnd().a(this, bmM());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bnd() != null) {
            for (int i = 0; i < this.eZC.length; i++) {
                if (gVar == this.eZC[i]) {
                    this.eZD[i] = 100.0f;
                    if (ps(i)) {
                        bnd().a(this);
                    } else {
                        bnd().a(this, bmM());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bnd() != null) {
            bnd().b(gVar);
        }
    }

    private float bmM() {
        float f = 0.0f;
        for (float f2 : this.eZD) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean ps(int i) {
        for (int i2 = 0; i2 < this.eZC.length; i2++) {
            if (i2 != i && !this.eZC[i2].gt()) {
                return false;
            }
        }
        return true;
    }
}
