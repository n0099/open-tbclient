package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.b.k;
/* loaded from: classes.dex */
public abstract class d<T extends i, R extends k> extends e<T, R> {
    protected abstract boolean AO();

    public d(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.d.e, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.AF() == 16777218) {
            if (AO()) {
                dI(33554439);
                return true;
            }
            dI(33554440);
            return true;
        }
        return false;
    }
}
