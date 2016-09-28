package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.homepage.personalize.b.i;
import com.baidu.tieba.homepage.personalize.b.q;
/* loaded from: classes.dex */
class j implements AbsListView.RecyclerListener {
    final /* synthetic */ a cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.cFs = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof q.a) {
                ((q.a) view.getTag()).cGI.stopPlay();
            } else if (view.getTag() instanceof i.a) {
                ((i.a) view.getTag()).cGw.stopPlay();
            }
        }
    }
}
