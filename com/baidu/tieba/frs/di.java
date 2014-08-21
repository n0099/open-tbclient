package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements AbsListView.RecyclerListener {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(cv cvVar) {
        this.a = cvVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(com.baidu.tieba.u.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(com.baidu.tieba.u.abstract_img_layout);
        if (frsCommonImageLayout != null) {
            frsCommonImageLayout.a();
        }
        if (view != null && (view instanceof UserPhotoLayout)) {
            ((UserPhotoLayout) view).a();
        }
    }
}
