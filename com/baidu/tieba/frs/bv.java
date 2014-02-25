package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements AbsListView.RecyclerListener {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(br brVar) {
        this.a = brVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
        CommonImageLayout commonImageLayout = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
        if (commonImageLayout != null) {
            commonImageLayout.a();
        }
    }
}
