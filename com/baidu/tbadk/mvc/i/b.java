package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class b extends d {
    protected abstract void Ce();

    protected abstract void Cf();

    public b(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public b() {
    }

    @Override // com.baidu.tbadk.mvc.i.d, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Br() == 33554440) {
            Ce();
            return true;
        } else if (bVar.Br() == 33554441) {
            Cf();
            return true;
        } else {
            return false;
        }
    }
}
