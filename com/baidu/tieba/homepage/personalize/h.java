package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ int VV;
    final /* synthetic */ g cFf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, int i) {
        this.cFf = gVar;
        this.VV = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        BdTypeListView bdTypeListView;
        b bVar2;
        BdTypeListView bdTypeListView2;
        b bVar3;
        BdTypeListView bdTypeListView3;
        bVar = this.cFf.this$0;
        bdTypeListView = bVar.bBT;
        bdTypeListView.requestFocusFromTouch();
        int i = this.VV;
        bVar2 = this.cFf.this$0;
        bdTypeListView2 = bVar2.bBT;
        if (i <= bdTypeListView2.getCount() - 1) {
            bVar3 = this.cFf.this$0;
            bdTypeListView3 = bVar3.bBT;
            bdTypeListView3.setSelection(this.VV);
        }
    }
}
