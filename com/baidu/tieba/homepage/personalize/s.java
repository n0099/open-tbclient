package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int WD;
    final /* synthetic */ r cLp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.cLp = rVar;
        this.WD = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        BdTypeListView bdTypeListView;
        n nVar2;
        BdTypeListView bdTypeListView2;
        n nVar3;
        BdTypeListView bdTypeListView3;
        nVar = this.cLp.this$0;
        bdTypeListView = nVar.aML;
        bdTypeListView.requestFocusFromTouch();
        int i = this.WD;
        nVar2 = this.cLp.this$0;
        bdTypeListView2 = nVar2.aML;
        if (i <= bdTypeListView2.getCount() - 1) {
            nVar3 = this.cLp.this$0;
            bdTypeListView3 = nVar3.aML;
            bdTypeListView3.setSelection(this.WD);
        }
    }
}
