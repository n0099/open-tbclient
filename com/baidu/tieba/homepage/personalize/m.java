package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.RecyclerListener {
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cuC = bVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        o oVar;
        o oVar2;
        o oVar3;
        if (view != null) {
            oVar = this.cuC.cuu;
            if (oVar != null) {
                oVar2 = this.cuC.cuu;
                if (oVar2.Kq() != null) {
                    oVar3 = this.cuC.cuu;
                    oVar3.Kq().aJ(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).TU().stopPlay();
            }
        }
    }
}
