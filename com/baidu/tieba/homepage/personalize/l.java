package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cqb = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.cqb.cpU;
            if (nVar != null) {
                nVar2 = this.cqb.cpU;
                if (nVar2.JI() != null) {
                    nVar3 = this.cqb.cpU;
                    nVar3.JI().bi(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.d) {
                ((com.baidu.tieba.homepage.personalize.b.d) view.getTag()).Po().stopPlay();
            }
        }
    }
}
