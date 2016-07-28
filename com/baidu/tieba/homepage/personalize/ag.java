package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.homepage.personalize.a.j;
import com.baidu.tieba.homepage.personalize.a.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AbsListView.RecyclerListener {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar) {
        this.ctN = zVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof r.a) {
                ((r.a) view.getTag()).cuq.stopPlay();
            } else if (view.getTag() instanceof j.a) {
                ((j.a) view.getTag()).cue.stopPlay();
            }
        }
    }
}
