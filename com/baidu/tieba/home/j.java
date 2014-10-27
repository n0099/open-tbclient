package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ f aMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.aMo = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        com.baidu.tieba.model.n nVar;
        Boolean bool;
        nVar = this.aMo.aMf;
        bool = this.aMo.aMj;
        nVar.dD(bool.booleanValue());
    }
}
