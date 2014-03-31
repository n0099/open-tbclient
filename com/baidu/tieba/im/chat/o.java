package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements AbsListView.RecyclerListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(com.baidu.tieba.im.h.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).a();
        }
        View findViewById2 = view.findViewById(com.baidu.tieba.im.h.emotion_msgitem_image);
        if (findViewById2 != null && (findViewById2 instanceof GifView)) {
            ((GifView) findViewById2).a();
        }
    }
}
