package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.core.e;
/* loaded from: classes.dex */
public abstract class d<T extends h, R extends j> extends b<T, R> {
    protected abstract boolean aQ(boolean z);

    public d(e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xs() == 16777217) {
            if (aQ(bVar.xw())) {
                dF(33554437);
                return true;
            }
            dF(33554438);
            return true;
        }
        return false;
    }
}
