package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements AbsListView.RecyclerListener {
    final /* synthetic */ ax bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.bHQ = axVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        acVar = this.bHQ.aLe;
        if (acVar != null) {
            acVar2 = this.bHQ.aLe;
            acVar2.aR(view);
        }
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(r.h.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(r.h.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view instanceof UserPhotoLayout) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
