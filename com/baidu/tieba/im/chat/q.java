package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.RecyclerListener {
    final /* synthetic */ AbsMsglistView aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AbsMsglistView absMsglistView) {
        this.aZo = absMsglistView;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(com.baidu.tieba.q.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).reset();
        }
        View findViewById2 = view.findViewById(com.baidu.tieba.q.emotion_msgitem_image);
        if (findViewById2 != null && (findViewById2 instanceof GifView)) {
            ((GifView) findViewById2).stop();
        }
    }
}
