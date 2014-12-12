package com.baidu.tieba.discover;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ a asV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.asV = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        boolean z2;
        p pVar;
        p pVar2;
        z2 = this.asV.asP;
        if (z2) {
            pVar2 = this.asV.asH;
            pVar2.AY();
            return;
        }
        pVar = this.asV.asH;
        pVar.CK();
    }
}
