package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cb implements AbsListView.RecyclerListener {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bu buVar) {
        this.a = buVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(R.id.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).a();
        }
    }
}
