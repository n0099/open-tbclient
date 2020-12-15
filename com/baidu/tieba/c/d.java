package com.baidu.tieba.c;

import com.baidu.tieba.c.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e ibn;
    private float ibo;
    private boolean ibp;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.ibn = null;
        this.ibo = Float.MAX_VALUE;
        this.ibp = false;
    }

    public d a(e eVar) {
        this.ibn = eVar;
        return this;
    }

    @Override // com.baidu.tieba.c.b
    public void start() {
        cqx();
        this.ibn.B(cqv());
        super.start();
    }

    private void cqx() {
        if (this.ibn == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cqy = this.ibn.cqy();
        if (cqy > this.ibh) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cqy < this.ibi) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.c.b
    boolean fU(long j) {
        if (this.ibp) {
            if (this.ibo != Float.MAX_VALUE) {
                this.ibn.aC(this.ibo);
                this.ibo = Float.MAX_VALUE;
            }
            this.mValue = this.ibn.cqy();
            this.ibd = 0.0f;
            this.ibp = false;
            return true;
        }
        if (this.ibo != Float.MAX_VALUE) {
            this.ibn.cqy();
            b.a a2 = this.ibn.a(this.mValue, this.ibd, j / 2);
            this.ibn.aC(this.ibo);
            this.ibo = Float.MAX_VALUE;
            b.a a3 = this.ibn.a(a2.mValue, a2.ibd, j / 2);
            this.mValue = a3.mValue;
            this.ibd = a3.ibd;
        } else {
            b.a a4 = this.ibn.a(this.mValue, this.ibd, j);
            this.mValue = a4.mValue;
            this.ibd = a4.ibd;
        }
        this.mValue = Math.max(this.mValue, this.ibi);
        this.mValue = Math.min(this.mValue, this.ibh);
        if (C(this.mValue, this.ibd)) {
            this.mValue = this.ibn.cqy();
            this.ibd = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.c.b
    boolean C(float f, float f2) {
        return this.ibn.C(f, f2);
    }
}
