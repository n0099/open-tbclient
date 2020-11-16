package com.baidu.tieba.c;

import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e hQr;
    private float hQs;
    private boolean hQt;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.hQr = null;
        this.hQs = Float.MAX_VALUE;
        this.hQt = false;
    }

    public d a(e eVar) {
        this.hQr = eVar;
        return this;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        cmj();
        this.hQr.A(cmh());
        super.start();
    }

    private void cmj() {
        if (this.hQr == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cmk = this.hQr.cmk();
        if (cmk > this.hQn) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cmk < this.hQo) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.c.b
    boolean fq(long j) {
        if (this.hQt) {
            if (this.hQs != Float.MAX_VALUE) {
                this.hQr.aB(this.hQs);
                this.hQs = Float.MAX_VALUE;
            }
            this.mValue = this.hQr.cmk();
            this.hQk = 0.0f;
            this.hQt = false;
            return true;
        }
        if (this.hQs != Float.MAX_VALUE) {
            this.hQr.cmk();
            b.a a2 = this.hQr.a(this.mValue, this.hQk, j / 2);
            this.hQr.aB(this.hQs);
            this.hQs = Float.MAX_VALUE;
            b.a a3 = this.hQr.a(a2.mValue, a2.hQk, j / 2);
            this.mValue = a3.mValue;
            this.hQk = a3.hQk;
        } else {
            b.a a4 = this.hQr.a(this.mValue, this.hQk, j);
            this.mValue = a4.mValue;
            this.hQk = a4.hQk;
        }
        this.mValue = Math.max(this.mValue, this.hQo);
        this.mValue = Math.min(this.mValue, this.hQn);
        if (C(this.mValue, this.hQk)) {
            this.mValue = this.hQr.cmk();
            this.hQk = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.c.b
    boolean C(float f, float f2) {
        return this.hQr.C(f, f2);
    }
}
