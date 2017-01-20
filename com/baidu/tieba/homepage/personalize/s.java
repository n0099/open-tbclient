package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int Vn;
    final /* synthetic */ r cxL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.cxL = rVar;
        this.Vn = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        BdTypeListView bdTypeListView;
        n nVar2;
        BdTypeListView bdTypeListView2;
        n nVar3;
        BdTypeListView bdTypeListView3;
        nVar = this.cxL.this$0;
        bdTypeListView = nVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.Vn;
        nVar2 = this.cxL.this$0;
        bdTypeListView2 = nVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            nVar3 = this.cxL.this$0;
            bdTypeListView3 = nVar3.mListView;
            bdTypeListView3.setSelection(this.Vn);
        }
    }
}
