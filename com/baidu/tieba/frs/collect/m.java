package com.baidu.tieba.frs.collect;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.RecyclerListener {
    final /* synthetic */ l bgq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bgq = lVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(n.f.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(n.f.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
