package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class d extends e {
    public d(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bg(boolean z) {
        AM().addEventDelegate(this);
        dS(16777218);
    }

    protected void Cy() {
    }

    protected void Cz() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Bs() == 33554439) {
            Cy();
            return true;
        } else if (bVar.Bs() == 33554440) {
            Cz();
            return true;
        } else {
            return false;
        }
    }
}
