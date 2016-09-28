package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class s implements Runnable {
    private final /* synthetic */ int Wf;
    final /* synthetic */ r cGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, int i) {
        this.cGe = rVar;
        this.Wf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        BdTypeListView bdTypeListView;
        m mVar2;
        BdTypeListView bdTypeListView2;
        m mVar3;
        BdTypeListView bdTypeListView3;
        mVar = this.cGe.this$0;
        bdTypeListView = mVar.bCe;
        bdTypeListView.requestFocusFromTouch();
        int i = this.Wf;
        mVar2 = this.cGe.this$0;
        bdTypeListView2 = mVar2.bCe;
        if (i <= bdTypeListView2.getCount() - 1) {
            mVar3 = this.cGe.this$0;
            bdTypeListView3 = mVar3.bCe;
            bdTypeListView3.setSelection(this.Wf);
        }
    }
}
