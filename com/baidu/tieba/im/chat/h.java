package com.baidu.tieba.im.chat;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AbsListView.RecyclerListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(R.id.lay_msgitem_voice);
        if (findViewById != null && (findViewById instanceof ChatVoiceView)) {
            ((ChatVoiceView) findViewById).a();
        }
        View findViewById2 = view.findViewById(R.id.emotion_msgitem_image);
        if (findViewById2 != null && (findViewById2 instanceof GifView)) {
            ((GifView) findViewById2).b();
        }
    }
}
