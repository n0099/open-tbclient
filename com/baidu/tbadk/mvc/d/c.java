package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class c<T extends g, R extends i> extends a<T, R> {
    protected abstract boolean aB(boolean z);

    public c(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tr() == 16777217) {
            if (aB(bVar.tv())) {
                de(33554437);
                return true;
            }
            de(33554438);
            return true;
        }
        return false;
    }
}
