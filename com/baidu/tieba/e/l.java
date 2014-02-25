package com.baidu.tieba.e;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.a = iVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
    }
}
