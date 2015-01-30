package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.aPP = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        com.baidu.tieba.model.d dVar;
        Boolean bool;
        dVar = this.aPP.aPD;
        bool = this.aPP.aPH;
        dVar.du(bool.booleanValue());
    }
}
