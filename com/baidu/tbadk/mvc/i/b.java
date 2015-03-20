package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class b extends d {
    protected abstract void Bm();

    protected abstract void Bn();

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
        if (bVar.Az() == 33554440) {
            Bm();
            return true;
        } else if (bVar.Az() == 33554441) {
            Bn();
            return true;
        } else {
            return false;
        }
    }
}
