package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements AbsListView.RecyclerListener {
    final /* synthetic */ ax bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.bOZ = axVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        acVar = this.bOZ.aQP;
        if (acVar != null) {
            acVar2 = this.bOZ.aQP;
            acVar2.aP(view);
        }
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(w.h.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(w.h.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view instanceof UserPhotoLayout) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
