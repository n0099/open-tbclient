package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
final class m implements AbsListView.RecyclerListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.a = jVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.a.h.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.b();
        }
    }
}
