package com.baidu.tieba.discover;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ a auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.auc = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        boolean z2;
        p pVar;
        p pVar2;
        z2 = this.auc.atW;
        if (z2) {
            pVar2 = this.auc.atN;
            pVar2.By();
            return;
        }
        pVar = this.auc.atN;
        pVar.Dj();
    }
}
