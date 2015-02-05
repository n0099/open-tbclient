package com.baidu.tbadk.mvc.i;

import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.core.d {
    protected abstract void a(com.baidu.tbadk.mvc.b.a aVar);

    protected abstract void kA();

    protected abstract void kz();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yp() {
        wH().addEventDelegate(this);
        dispatchMvcEvent(yq());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.mvc.c.b yq() {
        return wJ().dJ(ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xm() == 33554435) {
            kA();
            return true;
        } else if (bVar.xm() == 33554436) {
            kz();
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.b) {
            a(((com.baidu.tbadk.mvc.c.b.b) bVar).xn());
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.c) {
            b(((com.baidu.tbadk.mvc.c.b.c) bVar).xo());
            return true;
        } else {
            return false;
        }
    }
}
