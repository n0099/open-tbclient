package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class d extends e {
    public d(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aT(boolean z) {
        wx().addEventDelegate(this);
        dz(16777218);
    }

    protected void yh() {
    }

    protected void yi() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xc() == 33554439) {
            yh();
            return true;
        } else if (bVar.xc() == 33554440) {
            yi();
            return true;
        } else {
            return false;
        }
    }
}
