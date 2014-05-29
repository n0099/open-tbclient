package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class cy implements AbsListView.RecyclerListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(ct ctVar) {
        this.a = ctVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.v.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.v.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.a();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).a();
        }
    }
}
