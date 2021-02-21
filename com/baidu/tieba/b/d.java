package com.baidu.tieba.b;

import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e ipa;
    private float ipb;
    private boolean ipc;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.ipa = null;
        this.ipb = Float.MAX_VALUE;
        this.ipc = false;
    }

    public d a(e eVar) {
        this.ipa = eVar;
        return this;
    }

    @Override // com.baidu.tieba.b.b
    public void start() {
        cqQ();
        this.ipa.u(cqO());
        super.start();
    }

    private void cqQ() {
        if (this.ipa == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cqR = this.ipa.cqR();
        if (cqR > this.ioU) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cqR < this.ioV) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.b.b
    boolean fZ(long j) {
        if (this.ipc) {
            if (this.ipb != Float.MAX_VALUE) {
                this.ipa.aH(this.ipb);
                this.ipb = Float.MAX_VALUE;
            }
            this.mValue = this.ipa.cqR();
            this.ioQ = 0.0f;
            this.ipc = false;
            return true;
        }
        if (this.ipb != Float.MAX_VALUE) {
            this.ipa.cqR();
            b.a a2 = this.ipa.a(this.mValue, this.ioQ, j / 2);
            this.ipa.aH(this.ipb);
            this.ipb = Float.MAX_VALUE;
            b.a a3 = this.ipa.a(a2.mValue, a2.ioQ, j / 2);
            this.mValue = a3.mValue;
            this.ioQ = a3.ioQ;
        } else {
            b.a a4 = this.ipa.a(this.mValue, this.ioQ, j);
            this.mValue = a4.mValue;
            this.ioQ = a4.ioQ;
        }
        this.mValue = Math.max(this.mValue, this.ioV);
        this.mValue = Math.min(this.mValue, this.ioU);
        if (D(this.mValue, this.ioQ)) {
            this.mValue = this.ipa.cqR();
            this.ioQ = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b.b
    boolean D(float f, float f2) {
        return this.ipa.D(f, f2);
    }
}
