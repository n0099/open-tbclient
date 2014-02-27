package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bw implements AbsListView.RecyclerListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.b();
        }
        CommonImageLayout commonImageLayout = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
        if (commonImageLayout != null) {
            commonImageLayout.a();
        }
    }
}
