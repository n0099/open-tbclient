package com.baidu.tieba.b;

import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e ioM;
    private float ioN;
    private boolean ioO;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.ioM = null;
        this.ioN = Float.MAX_VALUE;
        this.ioO = false;
    }

    public d a(e eVar) {
        this.ioM = eVar;
        return this;
    }

    @Override // com.baidu.tieba.b.b
    public void start() {
        cqJ();
        this.ioM.u(cqH());
        super.start();
    }

    private void cqJ() {
        if (this.ioM == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cqK = this.ioM.cqK();
        if (cqK > this.ioG) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cqK < this.ioH) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.b.b
    boolean fZ(long j) {
        if (this.ioO) {
            if (this.ioN != Float.MAX_VALUE) {
                this.ioM.aH(this.ioN);
                this.ioN = Float.MAX_VALUE;
            }
            this.mValue = this.ioM.cqK();
            this.ioC = 0.0f;
            this.ioO = false;
            return true;
        }
        if (this.ioN != Float.MAX_VALUE) {
            this.ioM.cqK();
            b.a a2 = this.ioM.a(this.mValue, this.ioC, j / 2);
            this.ioM.aH(this.ioN);
            this.ioN = Float.MAX_VALUE;
            b.a a3 = this.ioM.a(a2.mValue, a2.ioC, j / 2);
            this.mValue = a3.mValue;
            this.ioC = a3.ioC;
        } else {
            b.a a4 = this.ioM.a(this.mValue, this.ioC, j);
            this.mValue = a4.mValue;
            this.ioC = a4.ioC;
        }
        this.mValue = Math.max(this.mValue, this.ioH);
        this.mValue = Math.min(this.mValue, this.ioG);
        if (D(this.mValue, this.ioC)) {
            this.mValue = this.ioM.cqK();
            this.ioC = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b.b
    boolean D(float f, float f2) {
        return this.ioM.D(f, f2);
    }
}
