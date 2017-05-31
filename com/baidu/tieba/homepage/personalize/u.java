package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class u implements Runnable {
    private final /* synthetic */ int aaj;
    final /* synthetic */ t cBA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, int i) {
        this.cBA = tVar;
        this.aaj = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        BdTypeListView bdTypeListView;
        o oVar2;
        BdTypeListView bdTypeListView2;
        o oVar3;
        BdTypeListView bdTypeListView3;
        oVar = this.cBA.this$0;
        bdTypeListView = oVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.aaj;
        oVar2 = this.cBA.this$0;
        bdTypeListView2 = oVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            oVar3 = this.cBA.this$0;
            bdTypeListView3 = oVar3.mListView;
            bdTypeListView3.setSelection(this.aaj);
        }
    }
}
