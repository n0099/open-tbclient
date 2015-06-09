package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
/* loaded from: classes.dex */
public abstract class b<T extends i, R extends k> extends d<T, R> {
    protected abstract boolean BA();

    public b(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Bs() == 16777219) {
            if (BA()) {
                dS(33554440);
                return true;
            }
            dS(33554441);
            return true;
        }
        return false;
    }
}
