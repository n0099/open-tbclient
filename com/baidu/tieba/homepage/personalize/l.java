package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a cyA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cyA = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.cyA.cys;
            if (nVar != null) {
                nVar2 = this.cyA.cys;
                if (nVar2.KC() != null) {
                    nVar3 = this.cyA.cys;
                    nVar3.KC().aP(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).Tb().stopPlay();
            }
        }
    }
}
