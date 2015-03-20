package com.baidu.tbadk.mvc.i;

import android.support.v4.view.ViewCompat;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.tbadk.mvc.core.d {
    protected abstract void a(com.baidu.tbadk.mvc.b.a aVar);

    protected abstract void os();

    protected abstract void ot();

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.e.c cVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BD() {
        zT().addEventDelegate(this);
        dispatchMvcEvent(BE());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tbadk.mvc.c.b BE() {
        return zV().dM(ViewCompat.MEASURED_STATE_TOO_SMALL);
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Az() == 33554435) {
            ot();
            return true;
        } else if (bVar.Az() == 33554436) {
            os();
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.b) {
            a(((com.baidu.tbadk.mvc.c.b.b) bVar).AA());
            return true;
        } else if (bVar instanceof com.baidu.tbadk.mvc.c.b.c) {
            b(((com.baidu.tbadk.mvc.c.b.c) bVar).AB());
            return true;
        } else {
            return false;
        }
    }
}
