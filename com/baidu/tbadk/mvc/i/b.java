package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class b extends d {
    protected abstract void xY();

    protected abstract void xZ();

    public b(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.i.d, com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xm() == 33554440) {
            xY();
            return true;
        } else if (bVar.xm() == 33554441) {
            xZ();
            return true;
        } else {
            return false;
        }
    }
}
