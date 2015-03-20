package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class bm implements AbsListView.RecyclerListener {
    final /* synthetic */ bf aLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bf bfVar) {
        this.aLR = bfVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
