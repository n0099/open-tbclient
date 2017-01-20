package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cxb = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.cxb.cwT;
            if (nVar != null) {
                nVar2 = this.cxb.cwT;
                if (nVar2.JX() != null) {
                    nVar3 = this.cxb.cwT;
                    nVar3.JX().aR(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).Sd().stopPlay();
            }
        }
    }
}
