package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ i cIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.cIQ = iVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        x xVar;
        x xVar2;
        x xVar3;
        if (view != null) {
            xVar = this.cIQ.cIH;
            if (xVar != null) {
                xVar2 = this.cIQ.cIH;
                if (xVar2.aes() != null) {
                    xVar3 = this.cIQ.cIH;
                    xVar3.aes().aL(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).Wp().stopPlay();
            }
        }
    }
}
