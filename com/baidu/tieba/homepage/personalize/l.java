package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.homepage.personalize.b.i;
import com.baidu.tieba.homepage.personalize.b.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cKG = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        n nVar;
        n nVar2;
        n nVar3;
        if (view != null) {
            nVar = this.cKG.cKz;
            if (nVar != null) {
                nVar2 = this.cKG.cKz;
                if (nVar2.Kp() != null) {
                    nVar3 = this.cKG.cKz;
                    nVar3.Kp().bj(view);
                }
            }
            if (view.getTag() instanceof q.a) {
                ((q.a) view.getTag()).cLT.stopPlay();
            } else if (view.getTag() instanceof i.a) {
                ((i.a) view.getTag()).cLH.stopPlay();
            }
        }
    }
}
