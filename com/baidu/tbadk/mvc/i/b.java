package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class b extends d {
    protected abstract void Cf();

    protected abstract void Cg();

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
        if (bVar.Bs() == 33554440) {
            Cf();
            return true;
        } else if (bVar.Bs() == 33554441) {
            Cg();
            return true;
        } else {
            return false;
        }
    }
}
