package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.v;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class l implements AbsListView.RecyclerListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(v.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
    }
}
