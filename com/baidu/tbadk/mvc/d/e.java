package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
/* loaded from: classes.dex */
public abstract class e<T extends i, R extends k> extends c<T, R> {
    protected abstract boolean aU(boolean z);

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.AF() == 16777217) {
            if (aU(bVar.AJ())) {
                dI(33554437);
                return true;
            }
            dI(33554438);
            return true;
        }
        return false;
    }
}
