package com.baidu.tbadk.mvc.i;
/* loaded from: classes.dex */
public abstract class d extends e {
    public d(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZ(boolean z) {
        zZ().addEventDelegate(this);
        dI(16777218);
    }

    protected void BL() {
    }

    protected void BM() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.AF() == 33554439) {
            BL();
            return true;
        } else if (bVar.AF() == 33554440) {
            BM();
            return true;
        } else {
            return false;
        }
    }
}
