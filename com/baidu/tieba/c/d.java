package com.baidu.tieba.c;

import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e ibl;
    private float ibm;
    private boolean ibn;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.ibl = null;
        this.ibm = Float.MAX_VALUE;
        this.ibn = false;
    }

    public d a(e eVar) {
        this.ibl = eVar;
        return this;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        cqw();
        this.ibl.B(cqu());
        super.start();
    }

    private void cqw() {
        if (this.ibl == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cqx = this.ibl.cqx();
        if (cqx > this.ibf) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cqx < this.ibg) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.c.b
    boolean fU(long j) {
        if (this.ibn) {
            if (this.ibm != Float.MAX_VALUE) {
                this.ibl.aC(this.ibm);
                this.ibm = Float.MAX_VALUE;
            }
            this.mValue = this.ibl.cqx();
            this.ibb = 0.0f;
            this.ibn = false;
            return true;
        }
        if (this.ibm != Float.MAX_VALUE) {
            this.ibl.cqx();
            b.a a2 = this.ibl.a(this.mValue, this.ibb, j / 2);
            this.ibl.aC(this.ibm);
            this.ibm = Float.MAX_VALUE;
            b.a a3 = this.ibl.a(a2.mValue, a2.ibb, j / 2);
            this.mValue = a3.mValue;
            this.ibb = a3.ibb;
        } else {
            b.a a4 = this.ibl.a(this.mValue, this.ibb, j);
            this.mValue = a4.mValue;
            this.ibb = a4.ibb;
        }
        this.mValue = Math.max(this.mValue, this.ibg);
        this.mValue = Math.min(this.mValue, this.ibf);
        if (C(this.mValue, this.ibb)) {
            this.mValue = this.ibl.cqx();
            this.ibb = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.c.b
    boolean C(float f, float f2) {
        return this.ibl.C(f, f2);
    }
}
