package com.baidu.tieba.ala.a;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] fCX;
    private float[] fCY;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.fCX = gVarArr;
        this.fCY = new float[this.fCX.length];
        for (int i = 0; i < this.fCX.length; i++) {
            this.fCY[i] = this.fCX[i].getProgress();
        }
        this.mFactor = 1.0f / this.fCX.length;
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onAttach() {
        for (g gVar : this.fCX) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    protected void onDetach() {
        for (g gVar : this.fCX) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.a.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.fCX) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.a.g
    public boolean gJ() {
        for (g gVar : this.fCX) {
            if (!gVar.gJ()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        if (byG() != null) {
            for (int i = 0; i < this.fCX.length; i++) {
                if (gVar == this.fCX[i]) {
                    this.fCY[i] = f;
                }
            }
            byG().a(this, byp());
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        if (byG() != null) {
            for (int i = 0; i < this.fCX.length; i++) {
                if (gVar == this.fCX[i]) {
                    this.fCY[i] = 100.0f;
                    if (qI(i)) {
                        byG().a(this);
                    } else {
                        byG().a(this, byp());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        if (byG() != null) {
            byG().b(gVar);
        }
    }

    private float byp() {
        float f = 0.0f;
        for (float f2 : this.fCY) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean qI(int i) {
        for (int i2 = 0; i2 < this.fCX.length; i2++) {
            if (i2 != i && !this.fCX[i2].gJ()) {
                return false;
            }
        }
        return true;
    }
}
