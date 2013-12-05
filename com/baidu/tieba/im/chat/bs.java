package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1577a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bm bmVar) {
        this.f1577a = bmVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(R.id.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).a();
        }
    }
}
