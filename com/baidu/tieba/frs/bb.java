package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements AbsListView.RecyclerListener {
    final /* synthetic */ az bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(az azVar) {
        this.bRf = azVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        com.baidu.tieba.play.ac acVar;
        com.baidu.tieba.play.ac acVar2;
        acVar = this.bRf.aRh;
        if (acVar != null) {
            acVar2 = this.bRf.aRh;
            acVar2.aN(view);
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
