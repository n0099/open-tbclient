package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
final class l implements AbsListView.RecyclerListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.a = iVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.a.h.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.b();
        }
    }
}
