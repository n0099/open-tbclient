package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.core.e;
/* loaded from: classes.dex */
public abstract class c<T extends h, R extends j> extends d<T, R> {
    protected abstract boolean xk();

    public c(e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.d.d, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xc() == 16777218) {
            if (xk()) {
                dz(33554439);
                return true;
            }
            dz(33554440);
            return true;
        }
        return false;
    }
}
