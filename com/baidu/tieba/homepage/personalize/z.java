package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.homepage.personalize.a.j;
import com.baidu.tieba.homepage.personalize.a.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AbsListView.RecyclerListener {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.crd = sVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof r.a) {
                ((r.a) view.getTag()).crG.stopPlay();
            } else if (view.getTag() instanceof j.a) {
                ((j.a) view.getTag()).cru.stopPlay();
            }
        }
    }
}
