package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a czr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.czr = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.czr.czj;
            if (nVar != null) {
                nVar2 = this.czr.czj;
                if (nVar2.Lc() != null) {
                    nVar3 = this.czr.czj;
                    nVar3.Lc().aN(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).UB().stopPlay();
            }
        }
    }
}
