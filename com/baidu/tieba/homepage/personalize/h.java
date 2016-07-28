package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class h implements Runnable {
    private final /* synthetic */ int Tf;
    final /* synthetic */ g ctA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, int i) {
        this.ctA = gVar;
        this.Tf = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        BdTypeListView bdTypeListView;
        b bVar2;
        BdTypeListView bdTypeListView2;
        b bVar3;
        BdTypeListView bdTypeListView3;
        bVar = this.ctA.ctz;
        bdTypeListView = bVar.bqG;
        bdTypeListView.requestFocusFromTouch();
        int i = this.Tf;
        bVar2 = this.ctA.ctz;
        bdTypeListView2 = bVar2.bqG;
        if (i <= bdTypeListView2.getCount() - 1) {
            bVar3 = this.ctA.ctz;
            bdTypeListView3 = bVar3.bqG;
            bdTypeListView3.setSelection(this.Tf);
        }
    }
}
