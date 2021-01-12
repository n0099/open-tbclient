package com.baidu.tieba.b;

import com.baidu.tieba.b.b;
/* loaded from: classes.dex */
public final class d extends b<d> {
    private e ije;
    private float ijf;
    private boolean ijg;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.ije = null;
        this.ijf = Float.MAX_VALUE;
        this.ijg = false;
    }

    public d a(e eVar) {
        this.ije = eVar;
        return this;
    }

    @Override // com.baidu.tieba.b.b
    public void start() {
        cpz();
        this.ije.u(cpx());
        super.start();
    }

    private void cpz() {
        if (this.ije == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double cpA = this.ije.cpA();
        if (cpA > this.iiY) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (cpA < this.iiZ) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // com.baidu.tieba.b.b
    boolean fU(long j) {
        if (this.ijg) {
            if (this.ijf != Float.MAX_VALUE) {
                this.ije.aE(this.ijf);
                this.ijf = Float.MAX_VALUE;
            }
            this.mValue = this.ije.cpA();
            this.iiU = 0.0f;
            this.ijg = false;
            return true;
        }
        if (this.ijf != Float.MAX_VALUE) {
            this.ije.cpA();
            b.a a2 = this.ije.a(this.mValue, this.iiU, j / 2);
            this.ije.aE(this.ijf);
            this.ijf = Float.MAX_VALUE;
            b.a a3 = this.ije.a(a2.mValue, a2.iiU, j / 2);
            this.mValue = a3.mValue;
            this.iiU = a3.iiU;
        } else {
            b.a a4 = this.ije.a(this.mValue, this.iiU, j);
            this.mValue = a4.mValue;
            this.iiU = a4.iiU;
        }
        this.mValue = Math.max(this.mValue, this.iiZ);
        this.mValue = Math.min(this.mValue, this.iiY);
        if (D(this.mValue, this.iiU)) {
            this.mValue = this.ije.cpA();
            this.iiU = 0.0f;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b.b
    boolean D(float f, float f2) {
        return this.ije.D(f, f2);
    }
}
