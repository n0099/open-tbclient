package com.baidu.tbadk.mvc.i;

import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.core.d {
    protected abstract void a(com.baidu.tbadk.mvc.b.a aVar);

    protected abstract void kG();

    protected abstract void kH();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yf() {
        wx().addEventDelegate(this);
        dispatchMvcEvent(yg());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.mvc.c.b yg() {
        return wz().dD(ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xc() == 33554435) {
            kH();
            return true;
        } else if (bVar.xc() == 33554436) {
            kG();
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.b) {
            a(((com.baidu.tbadk.mvc.c.b.b) bVar).xd());
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.c) {
            b(((com.baidu.tbadk.mvc.c.b.c) bVar).xe());
            return true;
        } else {
            return false;
        }
    }
}
