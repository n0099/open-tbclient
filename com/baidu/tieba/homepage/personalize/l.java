package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a cxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cxa = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.cxa.cwS;
            if (nVar != null) {
                nVar2 = this.cxa.cwS;
                if (nVar2.Lc() != null) {
                    nVar3 = this.cxa.cwS;
                    nVar3.Lc().aN(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).Tz().stopPlay();
            }
        }
    }
}
