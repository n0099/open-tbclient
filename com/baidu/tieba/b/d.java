package com.baidu.tieba.b;

import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e inN;
    private float inO;
    private boolean inP;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.inN = null;
        this.inO = Float.MAX_VALUE;
        this.inP = false;
    }

    public d a(e eVar) {
        this.inN = eVar;
        return this;
    }

    @Override // com.baidu.tieba.b.b
    public void start() {
        ctr();
        this.inN.A(ctp());
        super.start();
    }

    private void ctr() {
        if (this.inN == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cts = this.inN.cts();
        if (cts > this.inH) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cts < this.inI) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.b.b
    boolean fU(long j) {
        if (this.inP) {
            if (this.inO != Float.MAX_VALUE) {
                this.inN.aE(this.inO);
                this.inO = Float.MAX_VALUE;
            }
            this.mValue = this.inN.cts();
            this.inD = 0.0f;
            this.inP = false;
            return true;
        }
        if (this.inO != Float.MAX_VALUE) {
            this.inN.cts();
            b.a a2 = this.inN.a(this.mValue, this.inD, j / 2);
            this.inN.aE(this.inO);
            this.inO = Float.MAX_VALUE;
            b.a a3 = this.inN.a(a2.mValue, a2.inD, j / 2);
            this.mValue = a3.mValue;
            this.inD = a3.inD;
        } else {
            b.a a4 = this.inN.a(this.mValue, this.inD, j);
            this.mValue = a4.mValue;
            this.inD = a4.inD;
        }
        this.mValue = Math.max(this.mValue, this.inI);
        this.mValue = Math.min(this.mValue, this.inH);
        if (C(this.mValue, this.inD)) {
            this.mValue = this.inN.cts();
            this.inD = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b.b
    boolean C(float f, float f2) {
        return this.inN.C(f, f2);
    }
}
