package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements AbsListView.RecyclerListener {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(au auVar) {
        this.bUk = auVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        com.baidu.tieba.play.aa aaVar;
        com.baidu.tieba.play.aa aaVar2;
        aaVar = this.bUk.aMM;
        if (aaVar != null) {
            aaVar2 = this.bUk.aMM;
            aaVar2.bj(view);
        }
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(r.g.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.reset();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(r.g.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.reset();
        }
        if (view instanceof UserPhotoLayout) {
            ((UserPhotoLayout) view).reset();
        }
    }
}
