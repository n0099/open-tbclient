package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.RecyclerListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.a = gVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(com.baidu.tieba.u.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).b();
        }
        View findViewById2 = view.findViewById(com.baidu.tieba.u.emotion_msgitem_image);
        if (findViewById2 != null && (findViewById2 instanceof GifView)) {
            ((GifView) findViewById2).c();
        }
    }
}
