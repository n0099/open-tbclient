package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class d extends e {
    public d(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aV(boolean z) {
        wN().addEventDelegate(this);
        dF(16777218);
    }

    protected void yx() {
    }

    protected void yy() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xs() == 33554439) {
            yx();
            return true;
        } else if (bVar.xs() == 33554440) {
            yy();
            return true;
        } else {
            return false;
        }
    }
}
