package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int VX;
    final /* synthetic */ r cqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.cqK = rVar;
        this.VX = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        BdTypeListView bdTypeListView;
        n nVar2;
        BdTypeListView bdTypeListView2;
        n nVar3;
        BdTypeListView bdTypeListView3;
        nVar = this.cqK.this$0;
        bdTypeListView = nVar.aMc;
        bdTypeListView.requestFocusFromTouch();
        int i = this.VX;
        nVar2 = this.cqK.this$0;
        bdTypeListView2 = nVar2.aMc;
        if (i <= bdTypeListView2.getCount() - 1) {
            nVar3 = this.cqK.this$0;
            bdTypeListView3 = nVar3.aMc;
            bdTypeListView3.setSelection(this.VX);
        }
    }
}
