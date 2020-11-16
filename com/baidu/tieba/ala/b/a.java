package com.baidu.tieba.ala.b;
/* loaded from: classes4.dex */
public class a extends g implements h {
    private g[] gtt;
    private float[] gtu;
    private float mFactor;

    public a(g... gVarArr) {
        this(null, gVarArr);
    }

    public a(String str, g... gVarArr) {
        this.gtt = gVarArr;
        this.gtu = new float[this.gtt.length];
        for (int i = 0; i < this.gtt.length; i++) {
            this.gtu[i] = this.gtt[i].getProgress();
        }
        this.mFactor = 1.0f / this.gtt.length;
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onAttach() {
        for (g gVar : this.gtt) {
            gVar.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    protected void onDetach() {
        for (g gVar : this.gtt) {
            gVar.detach();
        }
    }

    @Override // com.baidu.tieba.ala.b.g
    public float getProgress() {
        float f = 0.0f;
        for (g gVar : this.gtt) {
            f += gVar.getProgress() * this.mFactor;
        }
        return f;
    }

    @Override // com.baidu.tieba.ala.b.g
    public boolean ik() {
        for (g gVar : this.gtt) {
            if (!gVar.ik()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        if (bPX() != null) {
            for (int i = 0; i < this.gtt.length; i++) {
                if (gVar == this.gtt[i]) {
                    this.gtu[i] = f;
                }
            }
            bPX().a(this, bPD());
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        if (bPX() != null) {
            for (int i = 0; i < this.gtt.length; i++) {
                if (gVar == this.gtt[i]) {
                    this.gtu[i] = 100.0f;
                    if (uL(i)) {
                        bPX().a(this);
                    } else {
                        bPX().a(this, bPD());
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        if (bPX() != null) {
            bPX().b(gVar);
        }
    }

    private float bPD() {
        float f = 0.0f;
        for (float f2 : this.gtu) {
            f += f2 * this.mFactor;
        }
        return f;
    }

    private boolean uL(int i) {
        for (int i2 = 0; i2 < this.gtt.length; i2++) {
            if (i2 != i && !this.gtt[i2].ik()) {
                return false;
            }
        }
        return true;
    }
}
