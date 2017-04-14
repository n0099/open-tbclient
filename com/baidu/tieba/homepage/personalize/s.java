package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int aaO;
    final /* synthetic */ r cxH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.cxH = rVar;
        this.aaO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        BdTypeListView bdTypeListView;
        n nVar2;
        BdTypeListView bdTypeListView2;
        n nVar3;
        BdTypeListView bdTypeListView3;
        nVar = this.cxH.this$0;
        bdTypeListView = nVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.aaO;
        nVar2 = this.cxH.this$0;
        bdTypeListView2 = nVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            nVar3 = this.cxH.this$0;
            bdTypeListView3 = nVar3.mListView;
            bdTypeListView3.setSelection(this.aaO);
        }
    }
}
