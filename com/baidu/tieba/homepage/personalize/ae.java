package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class ae implements Runnable {
    private final /* synthetic */ int aak;
    final /* synthetic */ ad cJx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, int i) {
        this.cJx = adVar;
        this.aak = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar;
        BdTypeListView bdTypeListView;
        x xVar2;
        BdTypeListView bdTypeListView2;
        x xVar3;
        BdTypeListView bdTypeListView3;
        xVar = this.cJx.this$0;
        bdTypeListView = xVar.mListView;
        bdTypeListView.requestFocusFromTouch();
        int i = this.aak;
        xVar2 = this.cJx.this$0;
        bdTypeListView2 = xVar2.mListView;
        if (i <= bdTypeListView2.getCount() - 1) {
            xVar3 = this.cJx.this$0;
            bdTypeListView3 = xVar3.mListView;
            bdTypeListView3.setSelection(this.aak);
        }
    }
}
