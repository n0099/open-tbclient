package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ f aMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.aMC = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        com.baidu.tieba.model.n nVar;
        Boolean bool;
        nVar = this.aMC.aMt;
        bool = this.aMC.aMx;
        nVar.dD(bool.booleanValue());
    }
}
