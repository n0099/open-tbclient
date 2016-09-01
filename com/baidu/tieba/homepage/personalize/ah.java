package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.homepage.personalize.a.i;
import com.baidu.tieba.homepage.personalize.a.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AbsListView.RecyclerListener {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar) {
        this.cFs = zVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof q.a) {
                ((q.a) view.getTag()).cFU.stopPlay();
            } else if (view.getTag() instanceof i.a) {
                ((i.a) view.getTag()).cFI.stopPlay();
            }
        }
    }
}
