package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.RecyclerListener {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.cAU = bVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        o oVar;
        o oVar2;
        o oVar3;
        if (view != null) {
            oVar = this.cAU.cAM;
            if (oVar != null) {
                oVar2 = this.cAU.cAM;
                if (oVar2.aaC() != null) {
                    oVar3 = this.cAU.cAM;
                    oVar3.aaC().aJ(view);
                }
            }
            if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.b.f) {
                ((com.baidu.tieba.homepage.personalize.b.f) view.getTag()).UY().stopPlay();
            }
        }
    }
}
