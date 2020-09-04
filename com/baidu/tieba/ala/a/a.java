package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] fOs;
    private float[] fOt;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fOs = gVarArr;
        this.fOt = new float[this.fOs.length];
        for (int i = 0; i < this.fOs.length; i++) {
            this.fOt[i] = this.fOs[i].getProgress();
        }
        this.mFactor = 1.0f / this.fOs.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fOs) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fOs) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fOs) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean ij() {
        for (g gVar : this.fOs) {
            if (!gVar.ij()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (bHK() != null) {
            for (int i = 0; i < this.fOs.length; i++) {
                if (gVar == this.fOs[i]) {
                    this.fOt[i] = f;
                }
            }
            bHK().a(this, bHq());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (bHK() != null) {
            for (int i = 0; i < this.fOs.length; i++) {
                if (gVar == this.fOs[i]) {
                    this.fOt[i] = 100.0f;
                    if (sU(i)) {
                        bHK().a(this);
                    } else {
                        bHK().a(this, bHq());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (bHK() != null) {
            bHK().b(gVar);
        }
    }

    private float bHq() {
        float f = 0.0f;
        for (float f2 : this.fOt) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean sU(int i) {
        for (int i2 = 0; i2 < this.fOs.length; i2++) {
            if (i2 != i && !this.fOs[i2].ij()) {
                return false;
            }
        }
        return true;
    }
}
