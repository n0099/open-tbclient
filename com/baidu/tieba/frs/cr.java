package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.view.UserPhotoLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
final class cr implements AbsListView.RecyclerListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.a.h.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.b();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.a.h.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.a();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).a();
        }
    }
}
