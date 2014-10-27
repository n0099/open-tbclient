package com.baidu.tbadk.mvc.d;

import com.baidu.tbadk.mvc.b.g;
import com.baidu.tbadk.mvc.b.i;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class b<T extends g, R extends i> extends c<T, R> {
    protected abstract boolean ty();

    public b(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.d.c, com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tp() == 16777218) {
            if (ty()) {
                de(33554439);
                return true;
            }
            de(33554440);
            return true;
        }
        return false;
    }
}
