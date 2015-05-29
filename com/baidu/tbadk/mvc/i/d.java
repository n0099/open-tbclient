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
        AL().addEventDelegate(this);
        dS(16777218);
    }

    protected void Cx() {
    }

    protected void Cy() {
    }

    @Override // com.baidu.tbadk.mvc.i.e, com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Br() == 33554439) {
            Cx();
            return true;
        } else if (bVar.Br() == 33554440) {
            Cy();
            return true;
        } else {
            return false;
        }
    }
}
