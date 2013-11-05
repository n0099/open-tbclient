package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bn implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1441a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bh bhVar) {
        this.f1441a = bhVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(R.id.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).a();
        }
    }
}
