package com.baidu.tbadk.mvc.i;

import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.core.d {
    protected abstract void a(com.baidu.tbadk.mvc.b.a aVar);

    protected abstract void oI();

    protected abstract void oJ();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cv() {
        AL().addEventDelegate(this);
        dispatchMvcEvent(Cw());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.mvc.c.b Cw() {
        return AN().dW(ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Br() == 33554435) {
            oJ();
            return true;
        } else if (bVar.Br() == 33554436) {
            oI();
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.b) {
            a(((com.baidu.tbadk.mvc.c.b.b) bVar).Bs());
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.c) {
            b(((com.baidu.tbadk.mvc.c.b.c) bVar).Bt());
            return true;
        } else {
            return false;
        }
    }
}
