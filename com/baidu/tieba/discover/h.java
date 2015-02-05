package com.baidu.tieba.discover;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ a atZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.atZ = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        boolean z2;
        p pVar;
        p pVar2;
        z2 = this.atZ.atT;
        if (z2) {
            pVar2 = this.atZ.atK;
            pVar2.Bs();
            return;
        }
        pVar = this.atZ.atK;
        pVar.Dd();
    }
}
