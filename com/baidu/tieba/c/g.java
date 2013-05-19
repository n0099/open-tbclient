package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.c {
    com.baidu.tieba.a.q e;
    private h f = null;

    public g() {
        this.e = null;
        this.e = new com.baidu.tieba.a.q();
    }

    public com.baidu.tieba.a.q d() {
        return this.e;
    }

    public boolean e() {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
            return false;
        }
        return false;
    }

    public boolean f() {
        return this.f != null;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        if (this.f == null) {
            this.f = new h(this, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
            this.f.setPriority(3);
            this.f.execute(new Object[0]);
        }
    }

    public void a(String str, com.baidu.tieba.a.ac acVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.e.d().size()) {
                if (!str.equals(((com.baidu.tieba.a.p) this.e.d().get(i2)).a())) {
                    i = i2 + 1;
                } else {
                    com.baidu.tieba.a.p pVar = (com.baidu.tieba.a.p) this.e.d().remove(i2);
                    pVar.b(acVar.a());
                    pVar.a(1);
                    this.e.c().add(pVar);
                    return;
                }
            } else {
                return;
            }
        }
    }
}
