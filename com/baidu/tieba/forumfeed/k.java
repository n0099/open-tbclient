package com.baidu.tieba.forumfeed;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class k implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.f1295a = iVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
    }
}
