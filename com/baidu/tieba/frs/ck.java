package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class ck implements AbsListView.RecyclerListener {
    final /* synthetic */ cg bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar) {
        this.bhg = cgVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(n.g.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(n.g.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
