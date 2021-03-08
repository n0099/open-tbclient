package com.baidu.tieba.b;

import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e iqJ;
    private float iqK;
    private boolean iqL;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.iqJ = null;
        this.iqK = Float.MAX_VALUE;
        this.iqL = false;
    }

    public d a(e eVar) {
        this.iqJ = eVar;
        return this;
    }

    @Override // com.baidu.tieba.b.b
    public void start() {
        cqW();
        this.iqJ.u(cqU());
        super.start();
    }

    private void cqW() {
        if (this.iqJ == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cqX = this.iqJ.cqX();
        if (cqX > this.iqD) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cqX < this.iqE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.b.b
    boolean fZ(long j) {
        if (this.iqL) {
            if (this.iqK != Float.MAX_VALUE) {
                this.iqJ.aL(this.iqK);
                this.iqK = Float.MAX_VALUE;
            }
            this.mValue = this.iqJ.cqX();
            this.iqz = 0.0f;
            this.iqL = false;
            return true;
        }
        if (this.iqK != Float.MAX_VALUE) {
            this.iqJ.cqX();
            b.a a2 = this.iqJ.a(this.mValue, this.iqz, j / 2);
            this.iqJ.aL(this.iqK);
            this.iqK = Float.MAX_VALUE;
            b.a a3 = this.iqJ.a(a2.mValue, a2.iqz, j / 2);
            this.mValue = a3.mValue;
            this.iqz = a3.iqz;
        } else {
            b.a a4 = this.iqJ.a(this.mValue, this.iqz, j);
            this.mValue = a4.mValue;
            this.iqz = a4.iqz;
        }
        this.mValue = Math.max(this.mValue, this.iqE);
        this.mValue = Math.min(this.mValue, this.iqD);
        if (D(this.mValue, this.iqz)) {
            this.mValue = this.iqJ.cqX();
            this.iqz = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b.b
    boolean D(float f, float f2) {
        return this.iqJ.D(f, f2);
    }
}
