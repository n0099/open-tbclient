package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class u implements Runnable {
    private final /* synthetic */ int aak;
    final /* synthetic */ t cvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, int i) {
        this.cvi = tVar;
        this.aak = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        o oVar;
        BdTypeListView bdTypeListView;
        o oVar2;
        BdTypeListView bdTypeListView2;
        o oVar3;
        BdTypeListView bdTypeListView3;
        oVar = this.cvi.this$0;
        bdTypeListView = oVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.aak;
        oVar2 = this.cvi.this$0;
        bdTypeListView2 = oVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            oVar3 = this.cvi.this$0;
            bdTypeListView3 = oVar3.mListView;
            bdTypeListView3.setSelection(this.aak);
        }
    }
}
