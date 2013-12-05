package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.view.CommonImageLayout;
import com.baidu.tieba.voice.PlayVoiceBnt;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bp implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bn bnVar) {
        this.f1397a = bnVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
        if (playVoiceBnt != null) {
            playVoiceBnt.d();
        }
        CommonImageLayout commonImageLayout = (CommonImageLayout) view.findViewById(R.id.abstract_img_layout);
        if (commonImageLayout != null) {
            commonImageLayout.a();
        }
    }
}
