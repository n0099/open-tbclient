package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int aay;
    final /* synthetic */ r czh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.czh = rVar;
        this.aay = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        BdTypeListView bdTypeListView;
        n nVar2;
        BdTypeListView bdTypeListView2;
        n nVar3;
        BdTypeListView bdTypeListView3;
        nVar = this.czh.this$0;
        bdTypeListView = nVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.aay;
        nVar2 = this.czh.this$0;
        bdTypeListView2 = nVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            nVar3 = this.czh.this$0;
            bdTypeListView3 = nVar3.mListView;
            bdTypeListView3.setSelection(this.aay);
        }
    }
}
