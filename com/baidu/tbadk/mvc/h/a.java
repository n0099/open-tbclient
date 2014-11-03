package com.baidu.tbadk.mvc.h;

import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public abstract class a extends c implements com.baidu.tbadk.mvc.c.a {
    protected abstract void b(com.baidu.tbadk.mvc.b.a aVar);

    protected abstract void ud();

    protected abstract void ue();

    public a(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ub() {
        dispatchMvcEvent(uc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.mvc.c.b uc() {
        return tb().dj(16777216);
    }

    protected void b(com.baidu.tbadk.mvc.e.c cVar) {
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tr() == 33554435) {
            ud();
            return true;
        } else if (bVar.tr() == 33554436) {
            ue();
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.b) {
            b(((com.baidu.tbadk.mvc.c.b.b) bVar).ts());
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.c) {
            b(((com.baidu.tbadk.mvc.c.b.c) bVar).tt());
            return true;
        } else {
            return false;
        }
    }
}
