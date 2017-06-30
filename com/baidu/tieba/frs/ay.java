package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements AbsListView.RecyclerListener {
    final /* synthetic */ av cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(av avVar) {
        this.cdV = avVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        acVar = this.cdV.cdS;
        if (acVar != null) {
            acVar2 = this.cdV.cdS;
            acVar2.aL(view);
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
